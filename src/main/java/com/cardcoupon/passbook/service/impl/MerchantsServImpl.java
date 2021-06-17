package com.cardcoupon.passbook.service.impl;

import com.cardcoupon.passbook.constant.ErrorCode;
import com.cardcoupon.passbook.dao.MerchantsDao;
import com.cardcoupon.passbook.service.IMerchantsServ;
import com.cardcoupon.passbook.vo.CreateMerchantsRequest;
import com.cardcoupon.passbook.vo.CreateMerchantsResponse;
import com.cardcoupon.passbook.vo.PassTemplate;
import com.cardcoupon.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Implementation for Interfaces of Merchants Service
 */
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {
    /**
     * Merchants database interface
     */
    private MerchantsDao merchantsDao;

    public MerchantsServImpl(MerchantsDao merchantsDao){
        this.merchantsDao = merchantsDao;
    }

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


    @Override
    public Response buildMerchantsInfoById(Integer id) {
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}
