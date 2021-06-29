package com.cardcoupon.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.cardcoupon.passbook.constant.Constants;
import com.cardcoupon.passbook.constant.ErrorCode;
import com.cardcoupon.passbook.dao.MerchantsDao;
import com.cardcoupon.passbook.entity.Merchants;
import com.cardcoupon.passbook.service.IMerchantsServ;
import com.cardcoupon.passbook.vo.CreateMerchantsRequest;
import com.cardcoupon.passbook.vo.CreateMerchantsResponse;
import com.cardcoupon.passbook.vo.PassTemplate;
import com.cardcoupon.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Implementation for Interfaces of Merchants Service
 */
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {
    /**
     * Merchants database interface
     */
    private final MerchantsDao merchantsDao;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate){
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Create merchants according to requests
     * @param request {@link CreateMerchantsRequest} the request to create a merchant
     * @return
     */
    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {
        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        ErrorCode errorCode = request.validate(merchantsDao);

        if(errorCode != ErrorCode.SUCCESS){
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMessage(errorCode.getDesc());
        }
        else{
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);
        return response;
    }


    /**
     * build merchant by its ID
     * @param id the id of the merchant to be built
     * @return {@link Response} Response
     */
    @Override
    public Response buildMerchantsInfoById(Integer id) {
        Response response = new Response();
        Optional<Merchants> merchants = merchantsDao.findById(id);
        if (merchants == null){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMessage(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    /**
     * Drop template and get response
     * @param template {@link PassTemplate} the coupon object
     * @return {@link Response} Response
     */
    @Override
    public Response dropPassTemplate(PassTemplate template) {
        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);

        if(errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMessage(errorCode.getDesc());
        }
        else{
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,//topic
                    Constants.TEMPLATE_TOPIC,//key
                    passTemplate//value
            );
            log.info("DropPassTemplate: {}", passTemplate);
        }
        return response;
    }
}
