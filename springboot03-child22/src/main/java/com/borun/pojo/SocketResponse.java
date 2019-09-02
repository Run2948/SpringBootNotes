package com.borun.pojo;

//服务器向浏览器响应数据的封装实体类
public class SocketResponse {
	private String responseMessage;

	public SocketResponse(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
