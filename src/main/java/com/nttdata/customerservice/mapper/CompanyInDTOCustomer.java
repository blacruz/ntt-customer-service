package com.nttdata.customerservice.mapper;

import java.time.LocalDateTime;
import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.model.CustomerStatus;
import com.nttdata.customerservice.model.CustomerType;
import com.nttdata.customerservice.service.dto.CompanyInDto;

public class CompanyInDTOCustomer {
  
  public static Customer map(CompanyInDto in)
  {
    Customer customerCompany = new Customer();
    customerCompany.setFirstName(in.getFirstName());
    customerCompany.setCreateDate(LocalDateTime.now());
    customerCompany.setCustomerType(CustomerType.COMPANY);
    customerCompany.setCustomerStatus(CustomerStatus.ENABLED);
    customerCompany.setAddresses(in.getAddresses());
    customerCompany.setContacts(in.getContacts());
    customerCompany.setDocuments(in.getDocuments());
    return customerCompany;
  }

}
