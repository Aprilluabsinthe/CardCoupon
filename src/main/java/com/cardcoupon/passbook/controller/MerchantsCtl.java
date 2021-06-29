package com.cardcoupon.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.cardcoupon.passbook.service.IMerchantsServ;
import com.cardcoupon.passbook.vo.CreateMerchantsRequest;
import com.cardcoupon.passbook.vo.PassTemplate;
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

    /**
     * MVC controller for createMerchants
     * @param request {@link CreateMerchantsRequest}Create Merchants Request
     * @return {@link Response} Response
     */
    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants:{}", JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);
    }

    /**
     * MVC Controller for buildMerchantsInfo
     * @param id the path variable for id
     * @return {@link Response} Response
     */
    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo:{}",id);
        return merchantsServ.buildMerchantsInfoById(id);
    }

    /**
     * MVC Controller for dropPassTemplate
     * @param passTemplate
     * @return {@link Response} Response
     */
    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("DropPassTempate:{}",passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}
