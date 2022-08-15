package com.ab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ab.Entitiy.TodoItem;
import com.ab.Services.TodoServiceImpl;

@Controller
public class TodoController {

	@Autowired
	private TodoServiceImpl serviceImpl;

	@RequestMapping("/test")
	public String testPage() {

		return "test";
	}

	@RequestMapping("/")
	public String mainPage(Model model) {

		List<TodoItem> list = serviceImpl.findAllTodo();

		model.addAttribute("list", list);

		return "main_page";
	}

	@RequestMapping("/new-todo-form")
	public String newStudentForm(Model model) {

		TodoItem todo = new TodoItem();
		model.addAttribute("todo", todo);

		return "new_todo_form";
	}

	@RequestMapping("/add")
	public String addTodo(TodoItem todoItem) {

		serviceImpl.saveTodoRequest(todoItem);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editForm(@PathVariable("id") int id) {

		// take user to edi_todo html page
		ModelAndView mvc = new ModelAndView("edit_todo");
		TodoItem todoItem = serviceImpl.getTodoItemById(id);
		mvc.addObject("todoItem", todoItem);
		return mvc;
	}

	@RequestMapping("/delete/{id}")
	public String deleteTodoRequest(@PathVariable("id") int id) {

		serviceImpl.deleteTodoRequest(id);

		return "redirect:/";
	}

	@RequestMapping("/delete/all")
	public String deleteAllTodoRequest() {
		serviceImpl.clearAllTodoRequest();

		return "redirect:/";

	}

} // end of class
