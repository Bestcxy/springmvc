package com.bestcxx.stu.springmvc.common.util;

/**
 * @theme 枚举类-设置静态变量
 * @author wujie
 */
public enum EnumUtil {
	//可以以逗号间隔  
	COMMON_DATABASE_PROPERTIES("config/jdbc.properties"),
    AJAX_RESPONSE_STATUS_TRUE("true"),     //ajax方法返回成功状态
    AJAX_RESPONSE_STATUS_FALSE("false");   //ajax方法返回失败状态
      
    private String temStr;  
    private EnumUtil(String temStr){  
        this.temStr=temStr;  
    }  
    @Override  
    public String toString() {
        return String.valueOf (this.temStr);  
    }  
}
