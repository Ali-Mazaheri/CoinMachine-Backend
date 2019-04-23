package com.assess.models;

public class ResultModel {

	private String errorMessage;
	private MoneyModel data;
	private boolean success;

	public ResultModel() {

	}

	public ResultModel(String errorMessage, MoneyModel data, boolean success) {
		this.errorMessage = errorMessage;
		this.data = data;
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public MoneyModel getData() {
		return data;
	}

	public void setData(MoneyModel data) {
		this.data = data;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
