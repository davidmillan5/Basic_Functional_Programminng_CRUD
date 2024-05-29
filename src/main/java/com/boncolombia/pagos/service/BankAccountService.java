package com.boncolombia.pagos.service;

import com.boncolombia.pagos.model.BankAccount;
import com.boncolombia.pagos.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;
}
