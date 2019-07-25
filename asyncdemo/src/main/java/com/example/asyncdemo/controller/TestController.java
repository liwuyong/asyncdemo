package com.example.asyncdemo.controller;

import com.example.asyncdemo.dto.TestRequest;
import com.example.asyncdemo.service.AsyncTestFacade;
import com.example.asyncdemo.service2.AsyncTestFacade2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: jin3pang
 * @Date: 2019/7/18 19:57
 */
@RestController
@RequestMapping
public class TestController {


    @Resource(name="asynctestfacade")
    private AsyncTestFacade asyncTestFacade;

    @Resource(name="asynctestfacade2")
    private AsyncTestFacade2 asyncTestFacade2;

    @RequestMapping("/test")
    public String test() throws Exception{

        TestRequest request = new TestRequest();
        asyncTestFacade.asyncProcess(request);
        return "success-test";
    }

    @RequestMapping("/test2")
    public String test2() throws Exception{
        TestRequest request = new TestRequest();
        asyncTestFacade2.asyncProcess(request);
        return "success-test2";
    }
}
