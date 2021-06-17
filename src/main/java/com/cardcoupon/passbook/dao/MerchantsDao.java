package com.cardcoupon.passbook.dao;

import com.cardcoupon.passbook.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface of Merchants Dao
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {
    /**
     * get Merchants by given Id
     * @param id the id to be found
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * get Merchants by given name
     * @param name the id to be found
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
