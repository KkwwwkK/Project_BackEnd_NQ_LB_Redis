package com.fsse2401.project_backend.repository;

import com.fsse2401.project_backend.data.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByPid(Integer pid);

//    boolean existsByPid(Integer pid);
    List<ProductEntity> findByNameContaining(String userInput);

//    List<ProductEntity> findByDescriptionLike(String userInput);
}
