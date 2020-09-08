package com.itsara.todolist.controllers;

import com.itsara.todolist.models.Tasks;
import com.itsara.todolist.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@RestController
public class TasksController {

  @Autowired
  private TasksRepository tasksRepository;

  @RequestMapping(value = "/tasks", method = RequestMethod.GET)
  public ResponseEntity<ArrayList<Tasks>> demo() {
    tasksRepository.save(new Tasks("Test", false));
    ArrayList<Tasks> tasks = (ArrayList<Tasks>) tasksRepository.findAll();
    return ResponseEntity.ok(tasks);
  }

}
