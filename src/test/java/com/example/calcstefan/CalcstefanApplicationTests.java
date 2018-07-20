package com.example.calcstefan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalcstefanApplicationTests {

    /**
     * more about tests:
     * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
     */

    @LocalServerPort
    private int port;

    @Autowired
    private calcStefanController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void addTwoDifferentNumbers() throws Exception {
        double result = controller.add(10.5, 0.7);
        assertThat(result).isEqualTo(11.2);
    }

    @Test
    public void addSecondNumberIsZero() throws Exception {
        double result = controller.add(5, 0);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void multiplyByZero() throws Exception {
        double result = controller.multiply(5, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void divideByZeroString() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/calc/divide?a=5.0&b=0",
                                                  String.class)).contains("Infinity");
    }

    @Test
    public void divideByZeroValue() throws Exception {
        double result = controller.divide(5, 0);
        assertThat(result).isEqualTo(Double.POSITIVE_INFINITY);
    }

    @Test
    public void powerExponentZero() throws Exception {
        double result = controller.power(5.0, 0.0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void sqrtWrongBase() throws Exception {
        double result = controller.power(-5.0, 0.5);
        assertThat(result).isNaN();
    }

}