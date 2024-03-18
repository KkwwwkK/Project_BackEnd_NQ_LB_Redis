package com.fsse2401.project_backend.service;

import com.fsse2401.project_backend.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2401.project_backend.data.product.domainObject.response.ProductResponseData;
import com.fsse2401.project_backend.data.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    // Get Service
    List<GetAllProductResponseData> getAllProducts();

    ProductResponseData getProductById(Integer pid);


    List<ProductResponseData> getProductsByUserInput(String userInput);


    // // Create method to query database for a product by id
    ProductEntity getEntityByPid(Integer pid);

    // Create method for querying database to find products by description
    List<ProductEntity> getProductsByName(String userInput);

    void updateProductToDatabase(ProductEntity productEntity);
}
