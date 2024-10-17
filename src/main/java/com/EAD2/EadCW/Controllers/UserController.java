package com.EAD2.EadCW.Controllers;

import com.EAD2.EadCW.services.UserService;
import com.EAD2.EadCW.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get-all")
    public List<UserDTO> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/new-user")
    public UserDTO newUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/update-user/{id}")
    public UserDTO updateUser(@PathVariable int id,
                             @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/get-user/{id}")
    public UserDTO getUser(@PathVariable int id){
        return userService.getUser(id);
    }
}
