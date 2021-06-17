package com.cardcoupon.passbook.service;

import com.cardcoupon.passbook.vo.CreateMerchantsRequest;
import com.cardcoupon.passbook.vo.PassTemplate;
import com.cardcoupon.passbook.vo.Response;

/**
 * <h1>The Interface of services for merchants</h1>
 */
public interface IMerchantsServ {
    /**
     * <h2>Create merchant according to request</h2>
     * @param request {@link CreateMerchantsRequest} the request to create a merchant
     * @return Response {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>build Merchants information by the given id</h2>
     * @param id the id of the merchant to be built
     * @return Response {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>Release pass coupoun</h2>
     * @param template {@link PassTemplate} the coupon object
     * @return Response {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}
