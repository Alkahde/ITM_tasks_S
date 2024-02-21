package com.itm.space.taskservice.repository;

import com.itm.space.taskservice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
   Task findTaskById(UUID ID);

}
