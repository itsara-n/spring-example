package com.itsara.todolist.services;

import com.itsara.todolist.models.Tasks;
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

  public List<Tasks> getAll() {
    return tasksRepository.findAll();
  }

  public List<Optional<Tasks>> getById(Long id) {
    Optional<Tasks> task = tasksRepository.findById(id);
    List<Optional<Tasks>> tasks = new ArrayList<>();
    if (task.isPresent()) {
      tasks.add(task);
    }
    return tasks;
  }

  public void addNew(Tasks tasks) {
    tasksRepository.save(tasks);
  }

  public void deleteById(Long id) {
    tasksRepository.deleteById(id);
  }

  public void updateById(Tasks tasks) {
    Tasks existingTasks = tasksRepository.getOne(tasks.getId());
    BeanUtils.copyProperties(tasks, existingTasks, "id");
    tasksRepository.saveAndFlush(existingTasks);
  }
}
