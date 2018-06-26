package com.example.calcstefan;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RestController  //Spring wil do the connection
@RequestMapping("/calc") //website address

public class calcStefanController {
//    http://127.0.0.1:8080/calc/add?a=5.0&b=0.0

//    @RequestMapping("/add")
//    public Double Add() {
//        return (double)(5 + 5);
//    }

    @RequestMapping(value = "/add", params = {"a", "b"})
    public Double Add(@RequestParam("a") double A, @RequestParam(value = "b", defaultValue = "0") double B) {
        return (A + B);
    }

    @RequestMapping(value = "/multiply", params = {"a", "b"})
    public Double Multiply(@RequestParam("a") double A, @RequestParam(value = "b", defaultValue = "1") double B) {
        return (A * B);
    }

    @RequestMapping(value = "/power", params = {"a", "b"})
    public Double Power(@RequestParam("a") double A, @RequestParam(value = "b", defaultValue = "1") double B) {
        return Math.pow(A, B);
        // it is unnecessary to check if (A>0) for sqrt operation
        // due to the fact that there are exception handling
        // see: https://en.wikipedia.org/wiki/IEEE_754
    }

    @RequestMapping(value = "/divide", params = {"a", "b"})
    public double Divide(@RequestParam("a") double A, @RequestParam(value = "b", defaultValue = "1") double B) {
        return A / B;
        // it is unnecessary to check if B==0
        // due to the fact that there are exception handling
        // see: https://en.wikipedia.org/wiki/IEEE_754
    }

    @RequestMapping(value = "/divide001", params = {"a", "b"})
    public String Divide001(@RequestParam("a") double A, @RequestParam(value = "b", defaultValue = "1") double B, Model model) throws Exception {
        String tmpResult = "";
        if (Math.abs(B) < 1e-10) {
//            model.addAttribute("message");
            tmpResult = "Message from Stefan: Illegal operation: divide by zero";
        } else {
            tmpResult = Double.toString(A / B);
        }
        return tmpResult;
    }
}