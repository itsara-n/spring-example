package com.itsara.todolist.services;

import com.itsara.todolist.models.Task;
import com.itsara.todolist.repositories.TasksRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

  @Autowired
  private TasksRepository tasksRepository;

  public List<Task> getAll() {
    return tasksRepository.findAll();
  }

  public List<Task> getById(Long id) {
    Optional<Task> task = tasksRepository.findById(id);
    List<Task> tasks = new ArrayList<>();
    if (task.isPresent()) {
      tasks.add(task.get());
    }
    return tasks;
  }

  public void addNew(Task task) {
    tasksRepository.save(task);
  }

  public void deleteById(Long id) {
    tasksRepository.deleteById(id);
  }

  public void updateById(Task task) {
    Task existingTask = tasksRepository.getOne(task.getId());
    BeanUtils.copyProperties(task, existingTask, "id");
    tasksRepository.saveAndFlush(existingTask);
  }
}
