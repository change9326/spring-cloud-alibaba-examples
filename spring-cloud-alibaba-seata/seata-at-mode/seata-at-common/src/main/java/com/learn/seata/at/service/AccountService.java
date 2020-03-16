package com.learn.seata.at.service;

import com.learn.seata.at.dto.AccountDTO;
import com.learn.seata.at.response.ObjectResponse;

/**
 * @author yujiaqi
 * @date 2020-03-15 16:06
 * @description
 */
public interface AccountService {
    /**
     * 从账户扣钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
