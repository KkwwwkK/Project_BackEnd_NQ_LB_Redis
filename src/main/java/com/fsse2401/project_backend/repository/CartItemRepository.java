package com.fsse2401.project_backend.repository;

import com.fsse2401.project_backend.data.cartItem.entity.CartItemEntity;
import com.fsse2401.project_backend.data.product.entity.ProductEntity;
import com.fsse2401.project_backend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
    Optional<CartItemEntity> findByUserAndProduct(UserEntity user, ProductEntity product);
    List<CartItemEntity> findAllByUser(UserEntity user);

    boolean existsByUserAndProduct(UserEntity user, ProductEntity product);

    boolean existsAllByUser(UserEntity user);

    void deleteAllByUser(UserEntity user);

    void deleteByUserAndProduct(UserEntity user, ProductEntity product);

}
