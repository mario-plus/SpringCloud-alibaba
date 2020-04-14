package com.mario.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPayment8007 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8007.class,args);
    }

    /*
    * 此配置是为了服务监控配置，与服务本身容错无关，spring升级后自带的坑
    * ServletRegistrationBean因为springboot的默认路径不是“/hystrix.stream”
    * 只要在自己的项目里配置下面的servlet就可以了
    * */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("vvvvvvv");
        return registrationBean;
    }
}
