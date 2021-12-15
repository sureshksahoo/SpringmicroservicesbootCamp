package com.ibm.controller.advice;

import com.ibm.model.ErrorItem;

public class ErrorResponse {
	private ErrorItem errorItem;

	public ErrorItem getErrorItem() {
		return errorItem;
	}

	public void setErrorItem(ErrorItem errorItem) {
		this.errorItem = errorItem;
	}

}
