package org.example.controller;

import org.example.dto.BillRequestDto;
import org.example.dto.BillResponseDto;
import org.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{billId}")
    public BillResponseDto getBill(@PathVariable Long billId) {
        return new BillResponseDto(
                billService.getBillById(billId));
    }

    @PostMapping
    public Long createBill(@RequestBody BillRequestDto billRequestDto) {
        return billService.createBill(billRequestDto.getAccountId(), billRequestDto.getAmount(),
                billRequestDto.getIsDefault(), billRequestDto.getOverdraftEnabled());
    }

    @PutMapping("/{billId}")
    public BillResponseDto updateBill(@PathVariable Long billId, @RequestBody BillRequestDto billRequestDTO) {
        return new BillResponseDto(
                billService.updateBill(billId, billRequestDTO.getAccountId(),
                        billRequestDTO.getAmount(), billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDto deleteBill(@PathVariable Long billId) {
        return new BillResponseDto(
                billService.deleteBill(billId));
    }
}
