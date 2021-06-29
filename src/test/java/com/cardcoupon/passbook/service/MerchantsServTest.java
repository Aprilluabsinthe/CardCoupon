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

    /**
     * {
     *  "data":{"id":19},
     *  "errorCode":0,
     *  "errorMessage":""
     * }
     */
    @Test
    public void testCreateMerchantServ(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("Costco");
        request.setLogoUrl("www.costco.com");
        request.setBusinessLicenseUrl("www.costco.com");
        request.setPhone("151-111-3456");
        request.setAddress("Philadelphia,PA");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    /***
     * {"data":
     *   {
     *      "address":"Pittsburgh,PA",
     *      "businessLicenseUrl":"www.google.com",
     *      "id":17,"isAudit":false,
     *      "logoUrl":"www.google.com",
     *      "name":"Google",
     *      "phone":"412-000-2021"
     *    },
     *  "errorCode":0,
     *  "errorMessage":""}
     */
    @Test
    public void  testBuildMerchantsInfoById(){
        System.out.println(
                JSON.toJSONString(merchantsServ.buildMerchantsInfoById(17))
        );
    }

    /**
     * {
     *  "errorCode":0,
     *  "errorMessage":""
     *  }
     */
    @Test
    public void testDropPass(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(11);
        passTemplate.setTitle("Sunscreen in Giant Eagle");
        passTemplate.setSummary("Summary: Sunscreen coupon for 2021");
        passTemplate.setDesc("Description:Can be used in all Giant Eagle store");
        passTemplate.setLimit(150000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(4);
        passTemplate.setStart(DateUtils.addDays(new Date(),-55));
        passTemplate.setEnd(DateUtils.addDays(new Date(),55));

        System.out.println(
                JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate))
        );


    }


}
