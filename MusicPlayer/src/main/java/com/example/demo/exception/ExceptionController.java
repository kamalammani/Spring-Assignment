package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

// All the exceptions are caught here
public class ExceptionController {
	
	@ExceptionHandler(value = EmptySongExcception.class)
	   public ResponseEntity<Object> exception(EmptySongExcception exception) {
		  return new ResponseEntity<>("Song should not be empty!", HttpStatus.BAD_REQUEST);
	   }
	
	 @ExceptionHandler(value = SongNotFoundException.class)
	   public ResponseEntity<Object> exception1(SongNotFoundException exception) {
	      return new ResponseEntity<>("Invalid Song Request!", HttpStatus.NOT_FOUND);
	   }
	 
	 @ExceptionHandler(value = DuplicateSongExcception.class)
	   public ResponseEntity<Object> exception2(DuplicateSongExcception exception) {
	      return new ResponseEntity<>("This song already exists in the player!", HttpStatus.BAD_REQUEST);
	   }
	 
	 @ExceptionHandler(value = EmptyListExcception.class)
	   public ResponseEntity<Object> exception3(EmptyListExcception exception) {
          return new ResponseEntity<>("There are no songs to display here!", HttpStatus.NOT_FOUND);
	   }
}
