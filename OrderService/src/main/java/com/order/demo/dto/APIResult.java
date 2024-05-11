package com.order.demo.dto;

public class APIResult {

	protected int errorCode = 0;
	protected String errorMsg = "SUCCESS";
	protected Object result = "";

	public APIResult() {
		super();
	}

	public APIResult(int errorCode, String errorMsg, Object result) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.result = result;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ApiResult [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", result=" + result + "]";
	}

}
