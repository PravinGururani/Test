package com.pravingururani.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class UserService {
     
    @Autowired
    UserRepository repository;
     
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> UserList = repository.findAll();
         
        if(UserList.size() > 0) {
            return UserList;
        } else {
            return new ArrayList<UserEntity>();
        }
    }
     
    public UserEntity getUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> User = repository.findById(id);
         
        if(User.isPresent()) {
            return User.get();
        } else {
            throw new RecordNotFoundException("No User record exist for given id");
        }
    }
     
    public UserEntity createOrUpdateUser(UserEntity entity) throws RecordNotFoundException
    {
        //Optional<UserEntity> User = repository.findById(entity.getId());
         
		
		/*
		 * if(User.isPresent()) { UserEntity newEntity = User.get();
		 * newEntity.setEmail(entity.getEmail());
		 * newEntity.setFirstName(entity.getFirstName());
		 * newEntity.setLastName(entity.getLastName());
		 * 
		 * newEntity = repository.save(newEntity);
		 * 
		 * return newEntity; } else {
		 */entity = repository.save(entity);
		  
		  return entity; }
		 
    	
    
     
    public void deleteUserById(Long id) 
    {
        Optional<UserEntity> User = repository.findById(id);
         
        if(User.isPresent())
        {
            repository.deleteById(id);
        }
    }
}
