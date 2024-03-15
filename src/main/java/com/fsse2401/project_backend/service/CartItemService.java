package com.fsse2401.project_backend.service;

import com.fsse2401.project_backend.data.user.domainObject.FirebaseUserData;

public interface CartItemService {
    void putCartItem(FirebaseUserData firebaseUserData,
                     Integer pid, Integer quantity);
}
