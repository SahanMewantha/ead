package com.EAD2.EadCW.Controllers;

import com.EAD2.EadCW.dto.CustomerDTO;
import com.EAD2.EadCW.services.CustomerService;
import com.EAD2.EadCW.services.UserService;
import com.EAD2.EadCW.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/get-all-customer")
    public List<CustomerDTO> getAll(){
        return customerService.getAllUsers();
    }

    @PostMapping("/new-customer")
    public CustomerDTO newUser(@RequestBody CustomerDTO customerDTO){
        return customerService.saveUser(customerDTO);
    }

    @PutMapping("/update-customer/{id}")
    public CustomerDTO updateUser(@PathVariable int id,
                              @RequestBody CustomerDTO customerDTO){
        return customerService.updateUser(id, customerDTO);
    }

    @DeleteMapping("/delete-customer/{id}")
    public String deleteUser(@PathVariable int id){
        customerService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/get-customer/{id}")
    public CustomerDTO getUser(@PathVariable int id){
        return customerService.getUser(id);
    }
}
