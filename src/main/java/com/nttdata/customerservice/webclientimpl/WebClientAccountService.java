package com.nttdata.customerservice.webclientimpl;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.nttdata.customerservice.dtoaccounts.BalanceDTO;
import com.nttdata.customerservice.webclient.AccountWebClient;
import reactor.core.publisher.Flux;


@Component
public class WebClientAccountService implements AccountWebClient {

  @Override
  public Flux<BalanceDTO> getAccountByIdCustomer(String idCustomer) {

    var account = WebClient.builder().baseUrl("http://localhost:5001")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    
    var balanceDto = account.get().uri("/accounts/byCustomer/{id}/balance",
        idCustomer).retrieve()
        .bodyToFlux(BalanceDTO.class);
    return balanceDto;
    
  }


}
