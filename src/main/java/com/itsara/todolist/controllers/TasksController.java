package com.itsara.todolist.controllers;

import com.itsara.todolist.models.Response;
import com.itsara.todolist.models.Task;
import com.itsara.todolist.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

  @Autowired
  protected TasksService tasksService;

  @RequestMapping(value = "/tasks", method = RequestMethod.GET)
  public Response getAllTasks() {
    List<Task> tasks = tasksService.getAll();
    Response response = new Response(HttpStatus.OK, HttpStatus.OK.value(), "Get all tasks success", tasks);
    return response;
  }

  @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
  public Response getTasksById(@PathVariable(required = true) Long id) {
    List<Task> tasks = tasksService.getById(id);
    if (tasks.size() == 0) {
      return new Response(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), "Get tasks id " + id + " failure", null);
    } else {
      return new Response(HttpStatus.OK, HttpStatus.OK.value(), "Get tasks id " + id + " success", tasks);
    }
  }

  @RequestMapping(value = "/tasks/create", method = RequestMethod.POST)
  public void postNewTasks(@RequestBody(required = true) final Task task) {
    tasksService.addNew(task);
  }

  @RequestMapping(value = "tasks/{id}", method = RequestMethod.DELETE)
  public void deleteTasksById(@PathVariable(required = true) Long id) {
    tasksService.deleteById(id);
  }

  @RequestMapping(value = "tasks", method = RequestMethod.PUT)
  public void updateTasksById(@RequestBody(required = true) final Task task) {
    tasksService.updateById(task);
  }

}
