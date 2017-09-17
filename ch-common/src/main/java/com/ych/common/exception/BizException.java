package com.ych.common.exception;

import com.ych.common.enums.ResponseEnum;

/**
 * Created by chenhao.ye on 2017/9/17.
 */
@SuppressWarnings("serial")
public class BizException extends RuntimeException {
    private ResponseEnum status;

    public BizException(ResponseEnum status) {
        super();
        this.status = status;
    }

    public ResponseEnum getStatus() {
        return status;
    }

    public void setStatus(ResponseEnum status) {
        this.status = status;
    }

}