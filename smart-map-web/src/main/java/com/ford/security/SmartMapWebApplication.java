package com.ford.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@EnableCaching
@EnableSwagger2
@MapperScan("com.ford.security.mapper")
public class SmartMapWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartMapWebApplication.class, args);
    }

 /*   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/
 /*   @Bean
    public FordSecurityProperties fordSecurityProperties() {
        return new FordSecurityProperties();
    }*/

}

