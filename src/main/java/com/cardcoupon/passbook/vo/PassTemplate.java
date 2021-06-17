package com.cardcoupon.passbook.vo;

import com.cardcoupon.passbook.constant.ErrorCode;
import com.cardcoupon.passbook.constant.TemplateColor;
import com.cardcoupon.passbook.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <h1>token definition</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {
    /** The id of the merchants that release the coupon */
    private Integer id;

    /** title of the coupon */
    private String title;

    /** summary for the coupon */
    private String summary;

    /** descripion for the coupon */
    private String desc;

    /** upper limit of the coupou released */
    private Long limit;

    /** has token or not, read from redis */
    private Boolean hasToken;

    /** the background color for the coupon */
    private Integer background;

    /** start time for the coupon */
    private Date start;

    /** end time for the coupon */
    private Date end;

    /**
     * check the validation of the coupon
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){
        if( null == merchantsDao.findById(this.id)){
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }
        return ErrorCode.SUCCESS;
    }

}
