package com.example.calcstefan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalcstefanApplicationTests {
    //https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html

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
    public void addTest01() throws Exception {
        double result = controller.Add(10.5, 0.7);
        assertThat(result).isEqualTo(11.2);
    }

    @Test
    public void addTest02() throws Exception {
        double result = controller.Add(5, 0);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void multiplyTest01() throws Exception {
        double result = controller.Multiply(5, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void divideTest01() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/calc/divide?a=5.0&b=0",
                String.class)).contains("Infinity");
        //I am not sure if it is necessary to check the content of the "output string"
    }

    @Test
    public void DivideTest02() throws Exception {
        double result = controller.Divide(5, 0);
        assertThat(result).isEqualTo(Double.POSITIVE_INFINITY);
    }

    @Test
    public void PowerTest01() throws Exception {
        double result = controller.Power(5.0, 0.0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void PowerTest02() throws Exception {
        double result = controller.Power(-5.0, 0.5);
        assertThat(result).isNaN();
    }

}