package com.example.Jpa_Haibernate.dao;

import com.example.Jpa_Haibernate.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserModel, Long> {
}
