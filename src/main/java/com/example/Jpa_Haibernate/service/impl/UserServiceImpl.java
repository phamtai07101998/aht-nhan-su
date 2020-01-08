package com.example.Jpa_Haibernate.service.impl;

import com.example.Jpa_Haibernate.dao.UserDAO;
import com.example.Jpa_Haibernate.exception.ResourceNotFoundException;
import com.example.Jpa_Haibernate.model.UserModel;
import com.example.Jpa_Haibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserModel> findAllUser() {
        return userDAO.findAll();
    }

    @Override
    public Optional<UserModel> findUserById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public UserModel insertUser(UserModel userModel) {
        userDAO.save(userModel);
        return userModel;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        Optional<UserModel> userModelDB = userDAO.findById(userModel.getId());
        if (userModelDB.isPresent()){
            UserModel userModelUpdate = userModelDB.get();
            userModelUpdate.setId(userModel.getId());
            userModelUpdate.setUserName(userModel.getUserName());
            userModelUpdate.setPassWord(userModel.getPassWord());
            userModelUpdate.setName(userModel.getName());
            userModelUpdate.setAge(userModel.getAge());
            userModelUpdate.setGender(userModel.getGender());
            userModelUpdate.setCity(userModel.getCity());
            userDAO.save(userModelUpdate);
            return userModelUpdate;
        }
        else {
            throw new ResourceNotFoundException("Not found"+userModel.getId());
        }
    }

    @Override
    public void deleteUser(long id) {
        Optional<UserModel> userModelDelete = userDAO.findById(id);
        if (userModelDelete.isPresent()){
            userDAO.delete(userModelDelete.get());
        }
        else throw new ResourceNotFoundException("Not found"+id);
    }


}
