package com.EAD2.EadCW.services;

import com.EAD2.EadCW.dto.UserDTO;
import com.EAD2.EadCW.entities.Customer;
import jakarta.transaction.Transactional;
import com.EAD2.EadCW.dto.CustomerDTO;
import com.EAD2.EadCW.entities.User;
import com.EAD2.EadCW.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerDTO saveUser(CustomerDTO customerDTO){
        Customer user = new Customer();
        user.setId(customerDTO.getId());
        user.setName(customerDTO.getName());
        user.setEmail(customerDTO.getEmail());
        customerRepository.save(user);
        return customerDTO;
    }
    public List<CustomerDTO> getAllUsers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> user_list = new ArrayList<>();
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmail(customer.getEmail());
            user_list.add(customerDTO);
        }
        return user_list;
    }
    public CustomerDTO updateUser(int id,CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customerRepository.save(customer);
        return customerDTO;
    }
    public void deleteUser(int id){
        customerRepository.deleteById(id);
    }
    public CustomerDTO getUser(int id){
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }
}
