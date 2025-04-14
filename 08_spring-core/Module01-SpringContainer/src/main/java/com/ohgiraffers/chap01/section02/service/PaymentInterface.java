package com.ohgiraffers.chap01.section02.service;

public interface PaymentInterface {

    boolean processPayment(String orderId, double amount);

}
