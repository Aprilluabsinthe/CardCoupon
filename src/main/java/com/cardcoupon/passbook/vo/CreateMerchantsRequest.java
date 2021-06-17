package com.cardcoupon.passbook.vo;

import com.cardcoupon.passbook.constant.ErrorCode;
import com.cardcoupon.passbook.dao.MerchantsDao;
import com.cardcoupon.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1> create a merchant request object</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {
    /**
     * Name of the merchants
     */
    private String name;

    /**
     * Logo Url of the merchants
     */
    private String logoUrl;

    /**
     * business License Url of the merchants
     */
    private String businessLicenseUrl;

    /**
     * Contact Phone
     */
    private String phone;

    /**
     * Contact address
     */
    private String address;

    /**
     * check the validation of request
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){
        if(this.name == null){
            return ErrorCode.EMPTY_NAME;
        }

        if(merchantsDao.findByName(this.name) != null){
            return ErrorCode.DUPLICATE_NAME;
        }

        if(this.logoUrl == null){
            return ErrorCode.EMPTY_LOGO;
        }

        if(this.businessLicenseUrl == null){
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }

        if(this.address == null){
            return ErrorCode.EMPTY_ADDRESS;
        }

        if(this.phone == null){
            return ErrorCode.ERROR_PHONE;
        }

        return ErrorCode.SUCCESS;
    }

    /**
     * transfer the applied object to {@link Merchants}Merchants object
     * @return
     */
    public Merchants toMerchants(){
        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);
        return merchants;

    }


}
