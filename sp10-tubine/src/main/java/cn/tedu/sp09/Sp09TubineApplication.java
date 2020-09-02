package cn.tedu.sp09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
//@EnableDiscoveryClient  可选 默认会添加
@EnableTurbine
@SpringBootApplication
public class Sp09TubineApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp09TubineApplication.class, args);
    }

}
