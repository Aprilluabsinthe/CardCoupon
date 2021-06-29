package com.cardcoupon.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.cardcoupon.passbook.service.IMerchantsServ;
import com.cardcoupon.passbook.vo.CreateMerchantsRequest;
import com.cardcoupon.passbook.vo.Response;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Merchants Service Controller
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsCtl {
    private final IMerchantsServ merchantsServ;

    @Autowired
    public MerchantsCtl(IMerchantsServ merchantsServ) {
        this.merchantsServ = merchantsServ;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants:{}", JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);
    }

    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo:{}",id);
    }
}
