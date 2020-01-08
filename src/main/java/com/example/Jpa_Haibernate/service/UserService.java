package com.example.Jpa_Haibernate.service;

import com.example.Jpa_Haibernate.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserModel> findAllUser();

    Optional<UserModel> findUserById(long id);

    UserModel insertUser(UserModel userModel);

    UserModel updateUser(UserModel userModel);

    void deleteUser(long id);
}
