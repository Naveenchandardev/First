package com.Project.First.Service;

 import com.Project.First.CustomerDTO.CustomerDTO;
 import com.Project.First.CustomerDTO.CustomerSaveDAO;
 import com.Project.First.CustomerDTO.CustomerUpdateDTO;

 import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDAO customerSaveDAO);
    List<CustomerDTO> getAllCustomers();
    String  updateCustomer(CustomerUpdateDTO customerUpdateDTO);
    String  deleteById(int id);
}
