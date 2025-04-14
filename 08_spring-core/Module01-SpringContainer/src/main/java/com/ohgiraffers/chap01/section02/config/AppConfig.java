package com.ohgiraffers.chap01.section02.config;


import com.ohgiraffers.chap01.section02.service.KaKaoPayGateway;
import com.ohgiraffers.chap01.section02.service.NaverPayGateway;
import com.ohgiraffers.chap01.section02.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**/

@Configuration
public class AppConfig {

    @Bean
    public KaKaoPayGateway kaKaoPayGateway() {
        return new KaKaoPayGateway();
    }

    @Bean
    public NaverPayGateway naverPayGateway() {
        return new NaverPayGateway();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(naverPayGateway()); //한 곳에서 정의해서 사용, 유지보수 용이
    }

}
