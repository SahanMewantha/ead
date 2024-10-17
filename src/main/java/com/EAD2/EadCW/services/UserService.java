package com.EAD2.EadCW.services;

import jakarta.transaction.Transactional;
import com.EAD2.EadCW.dto.UserDTO;
import com.EAD2.EadCW.entities.User;
import com.EAD2.EadCW.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserDTO saveUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return userDTO;
    }
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> user_list = new ArrayList<>();
        for(User user : users){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            user_list.add(userDTO);
        }
        return user_list;
    }
    public UserDTO updateUser(int id,UserDTO userDTO){
        User user = userRepository.findById(id).orElse(new User());
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return userDTO;
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public UserDTO getUser(int id){
        User user = userRepository.findById(id).orElse(new User());
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
