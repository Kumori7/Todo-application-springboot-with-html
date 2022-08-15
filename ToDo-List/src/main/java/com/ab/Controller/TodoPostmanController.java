package com.ab.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.Entitiy.TodoItem;
import com.ab.Services.TodoServiceImpl;

@RestController
public class TodoPostmanController {

	@Autowired
	private TodoServiceImpl serviceImpl;

	@GetMapping("/get-todo-postman")
	public List<TodoItem> getAllTodoRequest() {
		return serviceImpl.findAllTodo();
	}

	@PostMapping("/save-todo-postman")
	public TodoItem saveTodoRequest(@Valid @RequestBody TodoItem todoItem) {

		return serviceImpl.saveTodoRequest(todoItem);
	}

	@DeleteMapping("/postman/delete/{id}")
	public void deleteTodoRequest(@PathVariable("id") int id) {

		serviceImpl.deleteTodoRequest(id);
	}

	@PutMapping("/update-todo-postman")
	public TodoItem updateTodoRequest(@Valid @RequestBody TodoItem todoItem) {

		return serviceImpl.saveTodoRequest(todoItem);
	}

} // end of class
