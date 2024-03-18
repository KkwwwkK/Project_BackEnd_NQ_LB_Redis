package com.fsse2401.project_backend.data.transaction.domainObject.response;

import com.fsse2401.project_backend.constant.TransactionResult;

public class TransactionStatusSuccessData {
    private TransactionResult result;

    public TransactionStatusSuccessData(TransactionResult result) {
        this.result = result;
    }

    public TransactionResult getResult() {
        return result;
    }

    public void setResult(TransactionResult result) {
        this.result = result;
    }
}
