package com.learn.seata.at.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.seata.at.account.entity.Account;
import com.learn.seata.at.dto.AccountDTO;
import com.learn.seata.at.response.ObjectResponse;

/**
 * @author yujiaqi
 * @date 2020-03-15 20:42
 * @description
 */
public interface IAccountService extends IService<Account> {

    /**
     *  扣用户钱
     *
     * @param accountDTO
     * @return
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
