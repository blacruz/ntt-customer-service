package com.nttdata.customerservice.dtoaccounts;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDTO {
  private AccountType accountType;
  private BigDecimal balance;

}
