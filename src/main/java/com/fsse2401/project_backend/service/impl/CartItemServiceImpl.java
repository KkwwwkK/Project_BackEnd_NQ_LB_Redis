package com.fsse2401.project_backend.service.impl;

import com.fsse2401.project_backend.data.user.domainObject.FirebaseUserData;
import com.fsse2401.project_backend.data.user.entity.UserEntity;
import com.fsse2401.project_backend.service.CartItemService;
import com.fsse2401.project_backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;

    public CartItemServiceImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public void putCartItem(FirebaseUserData firebaseUserData,
                            Integer pid, Integer quantity){

        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);

    }
}
