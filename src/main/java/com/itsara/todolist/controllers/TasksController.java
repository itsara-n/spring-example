package com.itsara.todolist.controllers;

import com.itsara.todolist.models.Tasks;
import com.itsara.todolist.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@RestController
public class TasksController {

  @Autowired
  protected TasksService tasksService;

  @RequestMapping(value = "/tasks", method = RequestMethod.GET)
  public ResponseEntity<List<Tasks>> getAllTasks() {
    List<Tasks> tasks = tasksService.getAll();
    return ResponseEntity.ok(tasks);
  }

  @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
  public ResponseEntity<List<Optional<Tasks>>> getTasksById(@PathVariable(required = true) Long id) {
    return ResponseEntity.ok(tasksService.getById(id));
  }

}
