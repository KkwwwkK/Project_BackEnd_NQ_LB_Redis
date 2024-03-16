package com.fsse2401.project_backend.data.cartItem.dto;

import com.fsse2401.project_backend.constant.CartItemResult;
import com.fsse2401.project_backend.data.cartItem.domainObject.response.CartItemResponseData;

public class CartItemResponseDto {
    private CartItemResult result;

    public CartItemResponseDto(CartItemResponseData data){
        this.result = data.getResult();
    }

    public CartItemResult getResult() {
        return result;
    }

    public void setResult(CartItemResult result) {
        this.result = result;
    }
}
