package com.orange.basetool.global.util;

public class JsonResult {

    /**
     * 消息内容
     */
    private String msg = "";

    /**
     * 状态代码
     */
    private int code = -1;


    /**
     * 返回数据
     */
    private Object data = "";

    /**
     * 记录总数
     */
    private int count = -1;

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
     * 重载构造方法，设置状态码+数据+总数
     * @param code  状态
     * @param data  数据
     * @param count 总数
     */
    public JsonResult(int code,Object data,int count){
        this.setCode(code);
        this.setData(data);
        this.setCount(count);
    }

    /**
     * 重载构造方法，设置数据+总数，默认状态码：0
     * @param code  状态
     * @param data  数据
     */
    public JsonResult(Object data,int count){
        this.setCode(0);
        this.setData(data);
        this.setCount(count);
    }

    /**
     * 重载构造方法，默认状态码：0，设置消息
     * @param msg 消息
     */
    public JsonResult(String msg){
        this.setCode(0);
        this.setMsg(msg);
    }

    /**
     * 重载构造方法，默认状态码：0，设置数据
     * @param data 数据
     */
    public JsonResult(Object data){
        this.setCode(0);
        this.setData(data);
    }

    /**
     * 重载构造方法，设置状态码，消息，数据
     * @param code  状态
     * @param msg   消息
     * @param data  数据
     */
    public JsonResult(int code,String msg,Object data){
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    /**
     * 重载构造方法，设置全部参数
     * @param code  状态
     * @param msg   消息
     * @param data  数据
     * @param count 总数
     */
    public JsonResult(int code,String msg,Object data,int count){
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        this.setCount(count);
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString(){
        return "{code:"+getCode()+",msg:"+getMsg()+",data:"+data+"}";
    }
}
