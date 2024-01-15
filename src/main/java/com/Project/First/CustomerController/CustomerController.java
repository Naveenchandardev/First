package com.Project.First.CustomerController;

import com.Project.First.CustomerDTO.CustomerDTO;
import com.Project.First.CustomerDTO.CustomerSaveDAO;
import com.Project.First.CustomerDTO.CustomerUpdateDTO;
import com.Project.First.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

     public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerSaveDAO customerSaveDAO){
        String id = customerService.addCustomer(customerSaveDAO);
        return id;
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        return customerDTOS;
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String id = customerService.updateCustomer(customerUpdateDTO);
        return  id;
    }

    @DeleteMapping("/deletecustomer/{id}")
    public String deletecustomer(@PathVariable(value = "id")int id){
        return customerService.deleteById(id);
     }
}
