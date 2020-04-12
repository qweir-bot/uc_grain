package com.example.demo.util;

public class ReturnVO {

    /**
     * 返回代码
     */
    private String returnCode;

    /**
     * 返回信息
     */
    private String returnMessage;

    /**
     * 返回数据
     */
    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    /**
     * 默认构造，返回操作正确的返回代码和信息
     */
    public ReturnVO() {
        this.setReturnCode(Constants.RESPONSE_SUCCESS);
        this.setReturnMessage("请求成功!");
    }

    /**
     * 构造一个返回特定代码的ReturnVO对象
     * @param code
     */
    public ReturnVO(ReturnCode code) {
        this.setReturnCode(code.val());
        this.setReturnMessage(code.msg());
    }

    /**
     * 默认值返回，默认返回正确的code和message
     * @param data
     */
    public ReturnVO(Object data) {
        this.setReturnCode(ReturnCode.SUCCESS.val());
        this.setReturnMessage(ReturnCode.SUCCESS.msg());
        this.setData(data);
    }

    /**
     * 构造返回代码，以及自定义的错误信息
     * @param code
     * @param message
     */
    public ReturnVO(ReturnCode code, String message) {
        this.setReturnCode(code.val());
        this.setReturnMessage(message);
    }

    /**
     * 构造自定义的code，message，以及data
     * @param code
     * @param message
     * @param data
     */
    public ReturnVO(ReturnCode code, String message, Object data) {
        this.setReturnCode(code.val());
        this.setReturnMessage(message);
        this.setData(data);
    }

    @Override
    public String toString() {
        return "ReturnVO{" +
                "code='" + returnCode + '\'' +
                ", message='" + returnMessage + '\'' +
                ", data=" + data +
                '}';
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
