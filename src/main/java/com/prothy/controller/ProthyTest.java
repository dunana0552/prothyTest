package com.prothy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by dunana on 18/4/13.
 */
@Controller
public class ProthyTest implements Runnable {



    public ProthyTest() {

    }

    public void run() {
    }

//    @RequestMapping(value = "/prothy", method = RequestMethod.GET)
//    public String index() {
//
//        return "test";
//
//    }

    @RequestMapping(value = "/prothyTest", method = RequestMethod.POST)
    public void prothyTest(@RequestParam("requestTime") Integer requestTime) {

        ProthyTest prothyTest = new ProthyTest();

        prothyTest.run(requestTime);

    }

    public void run(int a) {

        Random random = new Random();
        int i = random.nextInt(10);

        if (a == 0) {

            try {
                Thread.sleep(i );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(a);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @RequestMapping(value = "/prothyGetRequest", method = RequestMethod.GET)
    public void prothyGetRequest(@RequestParam("RequestTime") Integer RequestTime) {
        ProthyTest prothyTest = new ProthyTest();
        prothyTest.run(RequestTime);
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(
            @RequestParam("FastCount") Integer FastCount,//快请求次数
            @RequestParam("RequsetCount") Integer RequsetCount,//总请求次数
            @RequestParam("RequestThreshold") Integer RequestThreshold,//阈值
            @RequestParam("LastTime") Integer LastTime//最大请求时间

//            @RequestParam("Post") Integer Post//Post=0 产生post请求；Post=1产生get请求

    ) {

        ProthyTest prothyTest = new ProthyTest();

//
            for (int i = 0; i <= RequsetCount; i++) {
                if (i == FastCount) {
                    Random random = new Random();
                    int fast = random.nextInt(RequestThreshold);
                    prothyTest.prothyTest(fast);
                    System.out.println("测试快响应时间"+fast);

                } else {
                    Random random = new Random();
                    int slow = random.nextInt(LastTime) + RequestThreshold;
                    prothyTest.prothyTest(slow);
                    System.out.println("测试慢相应时间"+slow);

                }
            }
//        } else if (Post == 1) {
//            for (int i = 0; i <= RequsetCount; i++) {
//                if (i == FastCount) {
//                    Random random = new Random();
//                    int fast = random.nextInt(RequestThreshold);
//                    prothyTest.prothyGetRequest(fast);
//                } else {
//                    Random random = new Random();
//                    int slow = random.nextInt(LastTime) + RequestThreshold;
//                    prothyTest.prothyGetRequest(slow);
//                }
//
//
//            }
//
//        }
        return "main";
    }




    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public String test2(
            @RequestParam("FastCount") Integer FastCount,//快请求次数
            @RequestParam("RequsetCount") Integer RequsetCount,//总请求次数
            @RequestParam("RequestThreshold") Integer RequestThreshold,//阈值
            @RequestParam("LastTime") Integer LastTime//最大请求时间
//            @RequestParam("Post") Integer Post//Post=0 产生post请求；Post=1产生get请求

    ) {

        ProthyTest prothyTest = new ProthyTest();

//        if (Post == 0) {
        for (int i = 0; i <= RequsetCount; i++) {
            if (i == FastCount) {
                Random random = new Random();
                int fast = random.nextInt(RequestThreshold);

                prothyTest.prothyTest(fast);
            } else {
                Random random = new Random();
                int slow = random.nextInt(LastTime) + RequestThreshold;
                prothyTest.prothyTest(slow);
            }
        }


        return "main";
    }
}

