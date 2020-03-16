package com.learn.seata.at.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.seata.at.account.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author yujiaqi
 * @date 2020-03-15 15:44
 * @description
 */

public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 通过用户ID 查询
     * @param userId
     * @return
     */
    Account selectByUserId(String userId);

    /**
     * 扣减余额
     * @param userId
     * @param amount
     * @return
     */
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}