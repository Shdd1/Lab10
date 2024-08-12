package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }

    public boolean updateUser(Integer id,User user){
        User u=userRepository.getById(id);
        if(u==null){
            return false;
        }
        u.setRole(user.getRole());
        u.setPassword(user.getPassword());
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        userRepository.save(u);
        return true;
    }
    public boolean deleteUser(Integer id){
        User u=userRepository.getById(id);
        if(u==null){
            return false;
        }
        userRepository.delete(u);
        return true;
    }

}
