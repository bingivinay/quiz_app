package com.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.beans.Quiz;

import jakarta.persistence.Id;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
