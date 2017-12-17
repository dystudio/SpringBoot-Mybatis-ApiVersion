package com.jc.controller;

import com.jc.util.apiVersion.ApiParam;
import com.jc.util.apiVersion.ApiVersion;
import com.jc.util.apiVersion.DefaultValueEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * 版本拦截器之后真正执行的方法
 * Created by jasonzhu on 2016/12/1.
 */
@Controller
public class TestApiVersionDo {
    public void test1(){}
    public String test2(@PathVariable("a") String path){return "URL参数值:"+path;}
    public String test3(){
        return "调用成功 没有参数";
    }
    public String test4(@ApiParam("a") String app){
        return "调用成功 一个参数 app:"+app;
    }
    public String test5(@ApiParam("av") Integer av,@ApiParam("a") String app,@ApiParam(value = "b",required = false) String b){
        return "调用成功 三个参数 app:"+app+" av:"+av+" b:"+b;
    }
    public String test6(@ApiParam("amount") BigDecimal amount, @ApiParam(value = "l",required = false) Long l, @ApiParam(value = "b",required = false,defaultValue = DefaultValueEnum.TRUE) Boolean b){
        return "调用成功 三个参数 amount:"+amount+" l:"+l+" b:"+b;
    }
    public String test7(@ApiParam("request") HttpServletRequest request, @ApiParam("response")HttpServletResponse response){ return request.getRequestURI();}
    public String test8(String a, @ApiParam("b") String b){return "成功";}
}
