package com.fsse2401.project_backend.service;

import com.fsse2401.project_backend.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2401.project_backend.data.cartItem.domainObject.response.GetUserCartResponseData;
import com.fsse2401.project_backend.data.cartItem.domainObject.response.UpdateUserCartResponseData;
import com.fsse2401.project_backend.data.user.domainObject.FirebaseUserData;

import java.util.List;

public interface CartItemService {
    CartItemResponseData putCartItem(FirebaseUserData firebaseUserData,
                                     Integer pid, Integer quantity);

    List<GetUserCartResponseData> getUserCartItemList(FirebaseUserData firebaseUserData);

    UpdateUserCartResponseData UpdateCartQuantityByPid(FirebaseUserData firebaseUserData,
                                                       Integer pid, Integer quantity);
}
