package com.prothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/prothy", method = RequestMethod.GET)
    public String index() {

        return "test";

    }

    @RequestMapping(value = "/prothyTest", method = RequestMethod.POST)
    public String prothyTest(@RequestParam("requestTime") String requestTime, @RequestParam("randomTime") String randomTime) {
//
//        String requestTime = request.getParameter("requestTime");
//        String randomTime = request.getParameter("randomTime");
        ProthyTest prothyTest = new ProthyTest();


        if (randomTime.equals("0")) {
            prothyTest.run(randomTime);
            return "third";

        } else if (!requestTime.equals(0)) {
            prothyTest.run(requestTime);
            return "second";
        }

        return "";
    }

    public void run(String a) {

        Random random = new Random();
        int i = random.nextInt(10);

        if (a.equals("0")) {

            try {
                Thread.sleep(i * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(Long.parseLong(a) * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @RequestMapping(value = "/prothyGetRandom",method = RequestMethod.GET)
    public String prothyGetRandom(){
        Random random = new Random();
        int i = random.nextInt(10);
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "prothyGetRandom";
    }


    @RequestMapping(value = "/prothyGetRequest",method = RequestMethod.GET)
    public String prothyGetRequest(@RequestParam("RequestTime") String  RequestTime){
        int i=Integer.valueOf(RequestTime);

        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "prothyGetRequest";
    }




}

