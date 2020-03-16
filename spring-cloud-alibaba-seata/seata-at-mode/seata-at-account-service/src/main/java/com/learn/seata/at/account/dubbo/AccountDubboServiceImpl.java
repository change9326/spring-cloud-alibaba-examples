package com.learn.seata.at.account.dubbo;

import com.learn.seata.at.account.service.IAccountService;
import com.learn.seata.at.dto.AccountDTO;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yujiaqi
 * @date 2020-03-15 21:08
 * @description
 */
@Service(version = "1.0.0",timeout = 3000)
@Slf4j
public class AccountDubboServiceImpl implements AccountService {

    @Autowired
    private IAccountService accountService;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        log.info("全局事务id ：{}",RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
    }


}
