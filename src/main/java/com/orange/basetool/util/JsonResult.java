package com.orange.basetool.util;

public class JsonResult {

    /**
     * 消息内容
     */
    private String msg = "";

    /**
     * 状态代码
     */
    private int code = 0;


    /**
     * 返回数据
     */
    private Object data = "";

    /**
     * 默认无参构造
     */
    public JsonResult(){

    }

    /**
     * 重载构造方法，默认设置状态码和文本消息
     * @param code 状态
     * @param msg 消息
     */
    public JsonResult(int code,String msg){
        this.setCode(code);
        this.setMsg(msg);
    }

    /**
     * 重载构造方法，设置状态
     * @param code  状态
     * @param data  数据
     */
    public JsonResult(int code,Object data){
            this.setCode(code);
            this.setData(data);
    }

    /**
     * 重载构造方法，默认状态200，设置消息
     * @param msg 消息
     */
    public JsonResult(String msg){
        this.setCode(200);
        this.setMsg(msg);
    }

    /**
     * 重载构造方法，默认状态200，设置数据
     * @param data 数据
     */
    public JsonResult(Object data){
        this.setCode(200);
        this.setData(data);
    }

    /**
     * 重载构造方法，可以设置全部参数
     * @param code  状态
     * @param msg   消息
     * @param data  数据
     */
    public JsonResult(int code,String msg,Object data){
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "[code = "+getCode()+" , msg = "+getMsg()+" , data = "+ data+"]";
    }
}
