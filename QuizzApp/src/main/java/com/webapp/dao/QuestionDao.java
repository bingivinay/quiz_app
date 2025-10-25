package com.webapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.beans.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
	@Query("SELECT q FROM Question q WHERE LOWER(q.category) = LOWER(:category)")
	List<Question>findByCategory(@RequestParam("category") String category);
	@Query(value = "SELECT * FROM question q WHERE q.category =:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<Question> findRandomQuestionByCategory(@RequestParam("category") String category, @RequestParam("numQ") int numQ);

	

	
}
