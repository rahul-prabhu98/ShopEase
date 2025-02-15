package service;

import entity.User;
import org.springframework.stereotype.Service;
import repo.UserRepo;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public void createUser(User user){
        userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow( () -> new RuntimeException("User with id" + id+ " not found"));
    }

    public void updateUser(User user){
        userRepo.findById(user.getId()).orElseThrow( () -> new RuntimeException("User with id" + user.getId()+ " not found"));
        userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.findById(id).orElseThrow( () -> new RuntimeException("User with id" + id+ " not found"));
        userRepo.deleteById(id);
    }

    public boolean verifyCredentials(String email, String password){
        User user = userRepo.findByEmail(email);
        if(user.getPassword() == password)
            return true;
        return false;
    }

}
