package com.ab.Services;

import java.util.List;

import com.ab.Entitiy.TodoItem;

public interface TodoService {

	public List<TodoItem> findAllTodo();

	public String creationTimeOfTodoRequest();

	public TodoItem saveTodoRequest(TodoItem todoItem);

	public TodoItem getTodoItemById(int id);

	public void deleteTodoRequest(int id);

	public void clearAllTodoRequest();

} // end of class
