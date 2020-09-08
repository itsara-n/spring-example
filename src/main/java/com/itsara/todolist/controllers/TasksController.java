package com.itsara.todolist.controllers;

import com.itsara.todolist.models.Tasks;
import com.itsara.todolist.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    System.out.println(tasksService.getById(id).size());
    return ResponseEntity.ok(tasksService.getById(id));
  }

  @RequestMapping(value = "/tasks/create", method = RequestMethod.POST)
  public void postNewTasks(@RequestBody(required = true) final Tasks tasks) {
    tasksService.addNew(tasks);
  }

  @RequestMapping(value = "tasks/{id}", method = RequestMethod.DELETE)
  public void deleteTasksById(@PathVariable(required = true) Long id) {
    tasksService.deleteById(id);
  }

  @RequestMapping(value = "tasks", method = RequestMethod.PUT)
  public void updateTasksById(@RequestBody(required = true) final Tasks tasks) {
    tasksService.updateById(tasks);
  }

}
