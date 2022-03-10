package com.xxx.paylearn.util;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @description
 * @date 2022/03/10 11:41
 */
@Slf4j
public class AlipayUtil {

    public static String callAliPay() {


        //构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        //设置应用Id
        certAlipayRequest.setAppId("2021000119632658");
        //设置应用私钥
        certAlipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCjWIwKPMVkHxpJlNGK8K5CPZe1rMMzIiKv5foAydl883WnPPGmmoJY4ZG3L+qFIxTTgoP/5JZWzGssGvxu/zZIBVd4ATMckdLDdS3eRP/dXYbka0kc3KHeSV1yC1wdQwmjvSovyJGg45ehMULxJp5NR+TX73lpgcYDbg0qWOm88b1mYhb+A/uTDaERy+SXj9pjSeOIRM0FlXSDRxeK2UJjCUslKAOoPHM7UpeT615deTdcJhJqMZcgCOy5R4VcudKwHg7lHo9y+dtMEDgNPOswLvmQmfXJGunOGXbWfK+OoqdwcvK29uupYeQND0kWkpHq/EtR6o0ymjRZWfGoHuppAgMBAAECggEAUT41SNI5Czc9B+Pw5L4YrfGch0vKOqB7yCkGU2YRukgM+IUjW831jueCZi564oU0Uo7TwG6dJ8a8d09kxoBBK0kc3B8coNUWkwixK5/98sgV035Y+vXxvHGY/KQRyKwTG1F2rhV/+Rm5zP6HYRHoIl/jvlLpfESDjCkseyeF+ecmkut5RWeQsMMOR24+RXeCipCWCeps9+SXqXjaYxwn7+EOXkcpfJ3KzY88l/TNRv0rQYNApUiiAbrWyw1rV7BZvOaYsRopS/Uy33BNVaiEV4xAlzaMDKHtFQT/7N6Z5lJUEow+cL34YSBAgo7O29uMum9SOHkWXSOKW60mJAR/UQKBgQDZfjgd1OUdR1D4Ifp8P072A4B+YPthFYG+XT+V808XO+Du6dujpnZYJQwK1ZQcAUhSXJMLElETxs0hxYL0eyRb4j5Pj/OxiXxCCRh6MwCy6SW4cylDZ01lwlAPtDmAqafalVJQcyGiUtSfWXRSK8ZJWLRoDTNmAYFDelPaJB3oiwKBgQDARCF1VjnOTZepIx1K6Ug2MZUNnKYy1raBy4zlHVji1eky3QqoKy8xdaKcJKXxoB9I2GFYQ4qhXNbyZPxG9AbcU8sIT9X/Ec7IsW3S+rQlbZPbFWefqkr5M1JdSUqTSgokr2U8eRQDYlvfDWT7i6+o7811cYzIlYQR1OFypB7jWwKBgBlgp+2bLMy4yJLbbB3ZST5ddD3K1Soj10q+GLBHfqAIZZua//zdbIumbvxIpYqK/8RUdvfgwEMdfEwHfttGDx0Fjh28f0Pk9fHCm++OSfOWTsdx8Iuj3x0TikH61obTxPk1WTB37qHBJnwddPwtjWp7hjlp6OhrHokgGe6nLjI3AoGAeEUmOOQrXOYkzOTuWgH77gquFsm7HWo62I6gIGJvS9ZL/klPdUsuRl4zzkEOnUtwxny0yCXX/oC45QBO34OfFwxDoXtvfhOBqwFyldvF/PPC3fVR0QsRwzlbeId0YxaZqcEeLun+nu9UUP9r//6tb5wyhhj13DPLXeww6ynHOKkCgYEA1i3Zgwvilfa7jmPZIDHxpIDmNmNIg8WBWh0kilqq4RdZI0eXShsmaHlVGISCDA+07JWDYxNBJys7EtLqiDRoJKagc//aL3Mkmhr0i+j1TNSTjqNtiuTM8xSTkvOICSOkuG1LlaZqz2R8azWREKHnaBGRyf6Iw/uZVj4csg5TG1Y=");
        //设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
        //设置字符集
        certAlipayRequest.setCharset("UTF-8");
        //设置签名类型
        certAlipayRequest.setSignType("RSA2");
        //设置应用公钥证书路径
        certAlipayRequest.setCertPath("D:/ideaProjects/log/pay-learn/src/main/resources/appCert/appCertPublicKey_2021000119632658.crt");
        //设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath("D:/ideaProjects/log/pay-learn/src/main/resources/alipaycert/alipayCertPublicKey_RSA2.crt");
        //设置支付宝根证书路径
        certAlipayRequest.setRootCertPath("D:/ideaProjects/log/pay-learn/src/main/resources/alipaycert/alipayRootCert.crt");
        //构造client
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        //构造API请求
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
            AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
            model.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
            model.setTotalAmount("88.88");
            model.setSubject("Iphone6 16G");
            model.setProductCode("FAST_INSTANT_TRADE_PAY");
            model.setSellerId("2088621958017261");
            request.setBizModel(model);

        //发送请求
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);

            log.info(JSON.toJSONString(request));
            log.info(response.getBody());
            return response.getBody();

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
