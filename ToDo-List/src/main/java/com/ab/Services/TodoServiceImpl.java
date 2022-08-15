package com.ab.Services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.Entitiy.TodoItem;
import com.ab.Reposistory.TodoReposistory;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoReposistory reposistory;

	// the format want to use to display todo-item creation date
	private static final String todoItemCreationDate = "dd/MM/yyyy: HH:mm";

	@Override
	public List<TodoItem> findAllTodo() {

		List<TodoItem> todoList = reposistory.findAll();

		return todoList;
	}

	@Override
	public String creationTimeOfTodoRequest() {

		// gets to get current time of local machine
		Calendar cal = Calendar.getInstance();

		// uses the pattern we will provide
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(todoItemCreationDate);

		// format local time with pattern and convert to string
		return simpleDateFormat.format(cal.getTime());
	}

	@Override
	public TodoItem saveTodoRequest(TodoItem todoItem) {

		todoItem.setDateCreated(creationTimeOfTodoRequest());

		return reposistory.save(todoItem);
	}

	@Override
	public TodoItem getTodoItemById(int id) {

		TodoItem todoItem = reposistory.findById(id).orElse(null);

		return todoItem;
	}

	@Override
	public void deleteTodoRequest(int id) {

		reposistory.deleteById(id);
	}

	@Override
	public void clearAllTodoRequest() {
		
		reposistory.deleteAll();
		
	}

}
