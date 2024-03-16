package com.fsse2401.project_backend.data.cartItem.domainObject.response;

import com.fsse2401.project_backend.constant.CartItemResult;

public class CartItemResponseData {
    private CartItemResult result;


    public CartItemResponseData(CartItemResult result) {
        this.result = result;
    }

    public CartItemResult getResult() {
        return result;
    }

    public void setResult(CartItemResult result) {
        this.result = result;
    }
}
