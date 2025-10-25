package com.webapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.beans.student;

@Repository
public interface UserRepository extends JpaRepository<student, Integer> {
    student findByEmail(String email);
}

