package com.itsara.todolist.controllers;

import com.itsara.todolist.models.Response;
import com.itsara.todolist.models.Task;
import com.itsara.todolist.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

  @Autowired
  protected TasksService tasksService;

  @RequestMapping(value = "/tasks", method = RequestMethod.GET)
  public ResponseEntity<Response> getAllTasks() {
    List<Task> tasks = tasksService.getAll();
    Response responseBody = new Response(HttpStatus.OK, tasks);
    return new ResponseEntity<Response>(responseBody, responseBody.getStatue());
  }

  @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
  public ResponseEntity<Response> getTasksById(@PathVariable(required = true) Long id) {
    List<Task> tasks = tasksService.getById(id);
    Response responseData = new Response();
    if (tasks.size() == 0) {
      responseData.setHttpStatus(HttpStatus.NOT_FOUND);
      responseData.setData(tasks);
    } else {
      responseData.setHttpStatus(HttpStatus.OK);
      responseData.setData(tasks);
    }
    return new ResponseEntity<Response>(responseData, responseData.getStatue());
  }

  @RequestMapping(value = "/tasks/create", method = RequestMethod.POST)
  public ResponseEntity<Response> postNewTasks(@RequestBody(required = true) final Task task) {
    Response responseData = new Response();
    try {
      tasksService.addNew(task);
      responseData.setHttpStatus(HttpStatus.OK);
    } catch (Exception e) {
      responseData.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Response>(responseData, responseData.getStatue());
  }

  @RequestMapping(value = "tasks/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Response> deleteTasksById(@PathVariable(required = true) Long id) {
    Response responseData = new Response();
    try {
      tasksService.deleteById(id);
      responseData.setHttpStatus(HttpStatus.OK);
    } catch (Exception e) {
      responseData.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Response>(responseData, responseData.getStatue());
  }

  @RequestMapping(value = "tasks", method = RequestMethod.PUT)
  public ResponseEntity<Response> updateTasksById(@RequestBody(required = true) final Task task) {
    Response responseData = new Response();
    try {
      tasksService.updateById(task);
      responseData.setHttpStatus(HttpStatus.OK);
    } catch (Exception e) {
      responseData.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Response>(responseData, responseData.getStatue());
  }

}
