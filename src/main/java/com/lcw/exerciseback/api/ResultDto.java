package com.lcw.exerciseback.api;

import com.lcw.exerciseback.api.ReturnCode;

public class ResultDto {

    /**
     * 成功
     */
    public static final boolean TRUE = true;

    /**
     * 失败
     */
    public static final boolean FALSE = false;

    /**
     * 0 是成功 错误的话每个模块定义可能不一样：
     */
    private int code = 0;

    /**
     * 结果标示
     */
    private boolean flag;

    /**
     * 结果详细
     */
    private String message;

    /**
     * 需要传回页面的数据
     */
    private Object data;

    public ResultDto() {

    }

    public ResultDto(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultDto(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public ResultDto(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public ResultDto(boolean flag, String message, Object data, int code) {
        this.flag = flag;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static ResultDto success(){
        return new ResultDto(TRUE,
                ReturnCode.OPERATE_SUCCESS.getMessage(),
                null,
                ReturnCode.OPERATE_SUCCESS.getCode());
    }

    public static ResultDto success(String message) {
        ResultDto dto = new ResultDto();
        dto.setFlag(TRUE);
        dto.setMessage(message);
        return dto;
    }

    public static ResultDto success(String message, Object data) {
        return new ResultDto(TRUE, message, data);
    }

    public static ResultDto success(Object data) {
        return new ResultDto(TRUE, data);
    }

    public static ResultDto success(int code, Object data) {
        return new ResultDto(TRUE, ReturnCode.getMessage(code), data, code);
    }

    public static ResultDto success(int code) {
        ResultDto dto = new ResultDto();
        dto.setFlag(TRUE);
        dto.setCode(code);
        dto.setMessage(ReturnCode.getMessage(code));
        return dto;
    }

    public static ResultDto fail(ReturnCode returnCode){
        return ResultDto.fail(returnCode,null);
    }

    public static ResultDto fail(ReturnCode returnCode,Object data){
        return new ResultDto(false,returnCode.getMessage(), data, returnCode.getCode());
    }

    public static ResultDto fail(String message, Object data) {
        return new ResultDto(FALSE, message, data);
    }

    public static ResultDto fail(String message) {
        ResultDto dto = new ResultDto();
        dto.setFlag(FALSE);
        dto.setMessage(message);
        dto.setCode(ReturnCode.OPERATE_FAIL.getCode());
        return dto;
    }

    public static ResultDto fail(int code) {
        ResultDto dto = new ResultDto();
        dto.setFlag(FALSE);
        dto.setCode(code);
        dto.setMessage(ReturnCode.getMessage(code));
        return dto;
    }

    public static ResultDto fail(int code, String failMsg) {
        ResultDto dto = new ResultDto();
        dto.setFlag(FALSE);
        dto.setCode(code);
        dto.setMessage(failMsg);
        return dto;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}