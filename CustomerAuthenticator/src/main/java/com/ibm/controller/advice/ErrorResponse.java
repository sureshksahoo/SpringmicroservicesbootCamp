package com.ibm.controller.advice;

import java.util.Date;

public class ErrorResponse {
	private String errorCode;
	private String errorMsg;
	private Date timestamp;
	public ErrorResponse() {}
	
	public ErrorResponse(String errorCode, String errorMsg, Date timestamp) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.timestamp = timestamp;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	

}
