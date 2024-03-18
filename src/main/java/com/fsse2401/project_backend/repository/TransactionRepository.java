package com.fsse2401.project_backend.repository;

import com.fsse2401.project_backend.data.transaction.entity.TransactionEntity;
import com.fsse2401.project_backend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    Optional<TransactionEntity> findByTid(Integer tid);

    boolean existsByTid(Integer tid);
}
