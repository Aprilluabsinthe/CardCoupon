package com.cardcoupon.passbook.service;

import com.alibaba.fastjson.JSON;
import com.cardcoupon.passbook.service.IMerchantsServ;
import com.cardcoupon.passbook.vo.CreateMerchantsRequest;
import com.cardcoupon.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Test Class for Merchants Service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {
    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
    public void testCreateMerchantServ(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("Google");
        request.setLogoUrl("www.google.com");
        request.setBusinessLicenseUrl("www.google.com");
        request.setPhone("412-000-2021");
        request.setAddress("Pittsburgh,PA");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    @Test
    public void  testBuildMerchantsInfoById(){
        System.out.println(
                JSON.toJSONString(merchantsServ.buildMerchantsInfoById(9))
        );
    }

    @Test
    public void testDropPass(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(9);
        passTemplate.setTitle("Icecream 2021");
        passTemplate.setSummary("Summary: Icecream coupoun for 2021");
        passTemplate.setDesc("Description:Can be uese in Pennsylvania.");
        passTemplate.setLimit(100000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(DateUtils.addDays(new Date(),-20));
        passTemplate.setEnd(DateUtils.addDays(new Date(),20));

        System.out.println(
                JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate))
        );


    }


}
