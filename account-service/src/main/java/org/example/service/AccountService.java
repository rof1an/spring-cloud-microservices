package org.example.service;

import org.example.entity.Account;
import org.example.exception.AccountNotFoundException;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Unable to find account with id = " + id));
    }

    public Long createAccount(String name, String email, String phone, List<Long> bills) {
        Account account = new Account(name, email, phone, OffsetDateTime.now(), bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account updateAccount(String name, String email, String phone, List<Long> bills) {
        Account account = Account.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .bills(bills)
                .build();

        return accountRepository.save(account);
    }

    public Account deleteAccountById(Long id) {
        Account deletedAccount = getAccountById(id);
        accountRepository.deleteById(id);
        return deletedAccount;
    }
}
