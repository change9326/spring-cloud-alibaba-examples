package com.learn.seata.at.business.service;

import com.learn.seata.at.dto.BusinessDTO;
import com.learn.seata.at.response.ObjectResponse;

/**
 * @author yujiaqi
 * @date 2020-03-16 15:30
 * @description
 */
public interface BusinessService {

    ObjectResponse handleBusiness(BusinessDTO businessDTO,boolean flag);
}
