package com.fsse2401.project_backend.service.impl;

import com.fsse2401.project_backend.constant.CartItemResult;
import com.fsse2401.project_backend.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2401.project_backend.data.cartItem.domainObject.response.GetUserCartResponseData;
import com.fsse2401.project_backend.data.cartItem.domainObject.response.UpdateUserCartResponseData;
import com.fsse2401.project_backend.data.cartItem.entity.CartItemEntity;
import com.fsse2401.project_backend.data.product.entity.ProductEntity;
import com.fsse2401.project_backend.data.user.domainObject.FirebaseUserData;
import com.fsse2401.project_backend.data.user.entity.UserEntity;
import com.fsse2401.project_backend.exception.cartItem.AddQuantityException;
import com.fsse2401.project_backend.exception.cartItem.GetUserCartException;
import com.fsse2401.project_backend.exception.product.DataMissingException;
import com.fsse2401.project_backend.repository.CartItemRepository;
import com.fsse2401.project_backend.repository.ProductRepository;
import com.fsse2401.project_backend.service.CartItemService;
import com.fsse2401.project_backend.service.ProductService;
import com.fsse2401.project_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartItemServiceImpl(UserService userService,
                               ProductService productService,
                               CartItemRepository cartItemRepository,
                               ProductRepository productRepository){
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartItemResponseData putCartItem(FirebaseUserData firebaseUserData,
                                            Integer pid, Integer quantity){

        // Get user entity
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        // Check if pid or quantity is null << Not working yet
        if (pid == null){
            throw new DataMissingException("pid input invalid!");
        }
        if (quantity == null){
            throw new DataMissingException("quantity input invalid!");
        }
        // Check if quantity is negative
        if (quantity <= 0){
            throw new AddQuantityException();
        }
        // Get product entity and check if product existed
        ProductEntity productEntity = productService.getEntityByPid(pid);
        // Check if quantity bigger than product's stock, if yes, return enum Failure
        if (quantity > productEntity.getStock()){
            return  new CartItemResponseData(CartItemResult.FAIL);
        }
        // Search if cart item exists
        CartItemEntity isExistCartItemEntity = cartItemRepository.findByUserAndProduct(userEntity, productEntity).orElse(null);
        if(isExistCartItemEntity != null){
            isExistCartItemEntity.setQuantity(isExistCartItemEntity.getQuantity() + quantity);
            cartItemRepository.save(isExistCartItemEntity);
        } else {
            // Add new cart item if do not find exist cartItem
            CartItemEntity cartItemEntity = new CartItemEntity(quantity, productEntity, userEntity);
            cartItemRepository.save(cartItemEntity);
        }
        // update product stock
        productEntity.setStock(productEntity.getStock() - quantity);
        productRepository.save(productEntity);

        return new CartItemResponseData(CartItemResult.SUCCESS);
    }

    @Override
    public List<GetUserCartResponseData> getUserCartItemList(FirebaseUserData firebaseUserData){
        // Get user entity
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

        // Get cart item list entity
        List<CartItemEntity> cartItemEntityList = cartItemRepository.findAllByUser(userEntity);

        // Check if list is empty
        if (cartItemEntityList.isEmpty()){
            throw new GetUserCartException("User do not have any cart items yet!");
        }
        // return list
        List<GetUserCartResponseData> getUserCartResponseData = new ArrayList<>();
        for(CartItemEntity cartItemEntity: cartItemEntityList){
            getUserCartResponseData.add(new GetUserCartResponseData(cartItemEntity));
        }
        return getUserCartResponseData;
    }

    @Override
    public UpdateUserCartResponseData UpdateCartQuantityByPid(FirebaseUserData firebaseUserData,
                                                              Integer pid, Integer quantity){
        // Get user entity
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        // Get product entity and check if product existed
        ProductEntity productEntity = productService.getEntityByPid(pid);

        // Check if pid or quantity is null << Not working yet
        if (pid == null){
            throw new DataMissingException("pid input invalid!");
        }
        if (quantity == null){
            throw new DataMissingException("quantity input invalid!");
        }
        // Check if quantity is negative and if quantity bigger than product's stock
        if (quantity <= 0 || quantity > productEntity.getStock()){
            throw new AddQuantityException();
        }
        // Search if cart item exists
        CartItemEntity isExistCartItemEntity = cartItemRepository.findByUserAndProduct(userEntity, productEntity).orElse(null);
        if(isExistCartItemEntity != null){
            // Update the product stock first before change the cart item quantity
            productEntity.setStock(productEntity.getStock()
                    + isExistCartItemEntity.getQuantity() - quantity);
            // Update the cart item quantity and its product entity
            isExistCartItemEntity.setQuantity(quantity);
            isExistCartItemEntity.setProduct(productEntity);
            // Update the database
            productRepository.save(productEntity);
            cartItemRepository.save(isExistCartItemEntity);
        } else {
            throw new GetUserCartException("User cart does not have this product!");
        }
        // Return the updated cartItem entity from database
        CartItemEntity updateCartItemEntity = cartItemRepository.findByUserAndProduct(userEntity, productEntity).orElse(null);
        if (updateCartItemEntity == null){
            throw new GetUserCartException("User cart does not have this product!");
        }
        return new UpdateUserCartResponseData(updateCartItemEntity);
    }


}
