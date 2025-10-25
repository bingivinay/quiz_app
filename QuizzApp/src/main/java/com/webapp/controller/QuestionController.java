package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.beans.Question;
import com.webapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("getallquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		
		return  questionservice.getallquestions();
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionservice.getQuestionsByCategory(category);
	}
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionservice.addQuestion(question);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable int id,@RequestBody Question updatedQuestion) {
		return questionservice.updateQuestion(id,updatedQuestion);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Question> deleteQuestion(@PathVariable int id) {
		return questionservice.deleteQuestion(id);
	}
	
	
	

}
