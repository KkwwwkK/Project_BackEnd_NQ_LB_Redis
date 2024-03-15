package com.fsse2401.project_backend.api;

import com.fsse2401.project_backend.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2401.project_backend.data.product.domainObject.response.ProductResponseData;
import com.fsse2401.project_backend.data.product.dto.response.GetAllProductResponseDto;
import com.fsse2401.project_backend.data.product.dto.response.ProductResponseDto;
import com.fsse2401.project_backend.service.ProductService;
import com.fsse2401.project_backend.util.ProductDataUtil;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/product")
public class ProductApi {
    // Add bean
    private final ProductService productService;
    @Autowired
    public ProductApi(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GetAllProductResponseDto> getAllProducts(){
        List<GetAllProductResponseDto> getAllProductResponseDtoList = new ArrayList<>();
        for(GetAllProductResponseData productResponseData: productService.getAllProducts()){
            getAllProductResponseDtoList.add(new GetAllProductResponseDto(productResponseData));
        }
        return getAllProductResponseDtoList;
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Integer id){
        return new ProductResponseDto(
                productService.getProductById(id)
        );
    }

    @GetMapping("/all/{user_input}")
    public List<ProductResponseDto> getProductsByUserInput(@PathVariable String user_input){
        return ProductDataUtil.toProductResponseDto(
                productService.getProductsByUserInput(user_input));
    }

}
