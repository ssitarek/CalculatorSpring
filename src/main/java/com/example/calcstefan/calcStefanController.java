package com.example.calcstefan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Spring wil do the connection
@RequestMapping("/calc") //website address

public class calcStefanController {


    /**
     * method realizes math add function
     *
     * @param firstTerm first term of addition
     * @param secondTerm second term of addition
     * @return result of addition
     * query example: http://127.0.0.1:8080/calc/add?a=5.0&b=2.0
     */
    @RequestMapping(value = "/add", params = { "a", "b" })
    public Double add(@RequestParam("a") double firstTerm, @RequestParam(value = "b", defaultValue = "0") double secondTerm) {
        return (firstTerm + secondTerm);
    }


    /**
     * method realizes math subtract function
     *
     * @param firstTerm first term of subtraction
     * @param secondTerm second term of subtraction
     * @return result of subtraction
     * query example: http://127.0.0.1:8080/calc/subtract?a=5.0&b=2.0
     */
    @RequestMapping(value = "/subtract", params = { "a", "b" })
    public Double subtract(@RequestParam("a") double firstTerm, @RequestParam(value = "b", defaultValue = "0") double secondTerm) {
        return (firstTerm - secondTerm);
    }


    /**
     * method realizes math multiply function
     *
     * @param firstCoefficient first coeffcient of multiplication
     * @param secondCoefficient second coefficient of multiplication
     * @return result of multiplication
     * query example: http://127.0.0.1:8080/calc/multiply?a=5.0&b=2.0
     */
    @RequestMapping(value = "/multiply", params = { "a", "b" })
    public Double multiply(@RequestParam("a") double firstCoefficient, @RequestParam(value = "b", defaultValue = "1") double secondCoefficient) {
        return (firstCoefficient * secondCoefficient);
    }


    /**
     * method realizes math power function
     *
     * @param base base of power
     * @param exponent exponent of power
     * @return result of power
     * query example: http://127.0.0.1:8080/calc/power?a=5.0&b=2.0
     */
    @RequestMapping(value = "/power", params = { "a", "b" })
    public Double power(@RequestParam("a") double base, @RequestParam(value = "b", defaultValue = "1") double exponent) {
        return Math.pow(base, exponent);
    }


    /**
     * method realizes math divide function without checking divideByZero
     *
     * @param firstCoefficient first coefficient of division
     * @param secondCoefficient second coefficient of division
     * @return result of division
     * query example: http://127.0.0.1:8080/calc/divide?a=5.0&b=2.0
     * query example: http://127.0.0.1:8080/calc/divide?a=5.0&b=0.0
     * <p>
     * it is unnecessary to check if (A>0) for sqrt operation due to the fact that there are exception handling
     * see: https://en.wikipedia.org/wiki/IEEE_754
     */
    @RequestMapping(value = "/divide", params = { "a", "b" })
    public double divide(@RequestParam("a") double firstCoefficient, @RequestParam(value = "b", defaultValue = "1") double secondCoefficient) {
        return firstCoefficient / secondCoefficient;
    }
}