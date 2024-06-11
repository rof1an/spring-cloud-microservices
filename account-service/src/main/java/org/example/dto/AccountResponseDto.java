package org.example.dto;

import lombok.Data;
import org.example.entity.Account;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class AccountResponseDto {

    private Long accountId;

    private String name;

    private String email;

    private String phone;

    private List<Long> bills;

    private OffsetDateTime creationTime;

    public AccountResponseDto(Account account) {
        this.accountId = account.getAccountId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.phone = account.getPhone();
        this.bills = account.getBills();
        this.creationTime = account.getCreationTime();
    }
}
