package com.ab.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.Entitiy.TodoItem;

@Repository
public interface TodoReposistory extends JpaRepository<TodoItem, Integer> {

}
