package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.beans.Question;
import com.webapp.beans.QuestionWrapper;
import com.webapp.beans.Response;
import com.webapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizzController {
	@Autowired
	QuizService quizservice;
	
	
	
	@PostMapping("create")
		public ResponseEntity<String> creatQuizz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
			return quizservice.CreateQuiz(category,numQ,title);
		}
	@GetMapping("getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizzQuestions(@PathVariable Integer id){
		
	return quizservice.getQuizQuestion(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response>responses){
		return quizservice.calculateResult(id,responses);
		
	}
}
