package com.webapp.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webapp.beans.Question;
import com.webapp.dao.QuestionDao;

@Service
public class QuestionService {
	@Autowired
	
	private QuestionDao questiondao;

	public ResponseEntity<List<Question>> getallquestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity(questiondao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<> (questiondao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e) {e.printStackTrace();}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		 
		 questiondao.save(question);
		 return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<Question> updateQuestion(int id, Question updatedQuestion) {
		// TODO Auto-generated method stub
		Optional<Question> existing= questiondao.findById(id);
		if(existing.isPresent()) {
			
			 Question q = existing.get();

	            // Update only non-null fields
	            if (updatedQuestion.getCategory() != null) q.setCategory(updatedQuestion.getCategory());
	            if (updatedQuestion.getDifficulty_level() != null) q.setDifficulty_level(updatedQuestion.getDifficulty_level());
	            if (updatedQuestion.getQuestion_title() != null) q.setQuestion_title(updatedQuestion.getQuestion_title());
	            if (updatedQuestion.getOption1() != null) q.setOption1(updatedQuestion.getOption1());
	            if (updatedQuestion.getOption2() != null) q.setOption2(updatedQuestion.getOption2());
	            if (updatedQuestion.getOption3() != null) q.setOption3(updatedQuestion.getOption3());
	            if (updatedQuestion.getOption4() != null) q.setOption4(updatedQuestion.getOption4());
	            if (updatedQuestion.getRight_answer() != null) q.setRight_answer(updatedQuestion.getRight_answer());

	            return new ResponseEntity<> (questiondao.save(q),HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	
	}

	public ResponseEntity<Question> deleteQuestion(int id) {
		// TODO Auto-generated method stub
		Optional<Question> q=questiondao.findById(id);
		if(q.isPresent()) {
			Question deletedQuestion=q.get();
			
			questiondao.deleteById(id);
			return new ResponseEntity<>(deletedQuestion,HttpStatus.OK);
					
		}else {
			throw new RuntimeException("question is not found to delete with this id:"+id);
		}
		
	}

	
		
	



	

	
}
