package com.nttdata.customerservice.webclient;


import com.nttdata.customerservice.dtoaccounts.BalanceDTO;
import reactor.core.publisher.Flux;

public interface AccountWebClient {
  
  public Flux<BalanceDTO> getAccountByIdCustomer(String idCustomer);

}
