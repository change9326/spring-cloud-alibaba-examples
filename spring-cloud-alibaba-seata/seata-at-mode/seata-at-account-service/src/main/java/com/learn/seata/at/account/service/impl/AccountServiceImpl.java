package com.learn.seata.at.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.seata.at.account.entity.Account;
import com.learn.seata.at.account.mapper.AccountMapper;
import com.learn.seata.at.account.service.IAccountService;
import com.learn.seata.at.dto.AccountDTO;
import com.learn.seata.at.enums.RspStatusEnum;
import com.learn.seata.at.response.ObjectResponse;
import org.springframework.stereotype.Service;

/**
 * @author yujiaqi
 * @date 2020-03-15 20:41
 * @description
 */
@Service
public class AccountServiceImpl  extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        int account = baseMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (account > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
