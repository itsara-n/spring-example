package com.itsara.todolist.repositories;

import com.itsara.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

}
