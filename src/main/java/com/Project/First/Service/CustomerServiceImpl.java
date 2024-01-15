package com.Project.First.Service;

 import com.Project.First.CustomerDTO.CustomerDTO;
 import com.Project.First.CustomerDTO.CustomerSaveDAO;
 import com.Project.First.CustomerDTO.CustomerUpdateDTO;
 import com.Project.First.CustomerRepo.CustomerRepo;
 import com.Project.First.Entity.Customer;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.ArrayList;
 import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String addCustomer(CustomerSaveDAO customerSaveDAO) {
        Customer customer = new Customer(customerSaveDAO.getCustomername(),customerSaveDAO.getCustomeraddress(),customerSaveDAO.getMobile());
        customerRepo.save(customer);
        return customer.getCustomername();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> results = customerRepo.findAll();
        List<CustomerDTO> list = new ArrayList<>();
        for(Customer user: results){
            CustomerDTO  res= new CustomerDTO(user.getCustomerid(), user.getCustomername(),user.getCustomeraddress(),user.getMobile());
            list.add(res);
        }
      return   list;
    }
    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
     if(customerRepo.existsById(customerUpdateDTO.getCustomerid())){
         Customer existing = customerRepo.getById(customerUpdateDTO.getCustomerid());
         existing.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
         existing.setCustomername(customerUpdateDTO.getCustomername());
         existing.setMobile(customerUpdateDTO.getMobile());
         customerRepo.save(existing);
     }
     return customerUpdateDTO.getCustomername();
    }

    @Override
    public String deleteById(int id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return "deleted";
        }
        else{
            return "User not found";
        }
    }
}
