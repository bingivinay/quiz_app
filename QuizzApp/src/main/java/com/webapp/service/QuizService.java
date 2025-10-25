package com.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webapp.beans.Question;
import com.webapp.beans.QuestionWrapper;
import com.webapp.beans.Quiz;
import com.webapp.beans.Response;
import com.webapp.dao.QuestionDao;
import com.webapp.dao.QuizDao;
@Service
public class QuizService {
		@Autowired
		QuizDao quizdao;
		@Autowired
		QuestionDao questiondao;
		public ResponseEntity<String> CreateQuiz(String category, int numQ, String title) {
			// TODO Auto-generated method stub
			List<Question> question=questiondao.findRandomQuestionByCategory(category,numQ);
			
			
			Quiz quiz=new Quiz();
			
			quiz.setTitle(title);
			quiz.setQuestions(question);
			quizdao.save(quiz);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
			// TODO Auto-generated method stub
			Optional<Quiz> quiz=quizdao.findById(id);
			List<Question> questionFromDb= quiz.get().getQuestions();
			List<QuestionWrapper> questionForUser=new ArrayList<>();
			for(Question q:questionFromDb) {
				QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
				questionForUser.add(qw);
			}
			
			return new ResponseEntity<>(questionForUser,HttpStatus.OK);
		}
		public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
			// TODO Auto-generated method stub
			Optional<Quiz> quiz=quizdao.findById(id);
			List<Question> questions=quiz.get().getQuestions();
			int right=0;
			int i=0;
			for(Response response:responses) {
				if(response.getResponse().equals(questions.get(i).getRight_answer()))
						right++;
				
				i++;
			}
			return new ResponseEntity<>(right,HttpStatus.OK);
		}
		
	

}
