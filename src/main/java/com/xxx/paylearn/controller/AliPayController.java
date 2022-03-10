package com.xxx.paylearn.controller;

import com.xxx.paylearn.util.AlipayUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;

/**
 * @description
 * @date 2022/03/10 16:14
 */
@RestController
public class AliPayController {

    @GetMapping("/pay")
    public String alipay() {
        /*URL resource = this.getClass().getClassLoader().getResource("application.properties");
        File file = new File(resource.getFile());
        System.out.println(file.exists());*/

        return AlipayUtil.callAliPay();
    }

}
