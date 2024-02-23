package com.itm.space.taskservice.repository;

import com.itm.space.taskservice.BaseIntegrationTest;
import com.itm.space.taskservice.entity.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TaskRepositoryTest extends BaseIntegrationTest {

   @Autowired
    private TaskRepository taskRepository;

@DisplayName("Тест на получение и сохранение сущности")
@Test
public void SaveAndFindTask(){
    Task task = new Task();
    task.setTitle("testTitle");
    task.setText("text");
    task.set_archived(false);
    task.setCreated(LocalDateTime.now());
    task.setCreated_by(UUID.randomUUID());
    task.setUpdated(LocalDateTime.now());
    task.setUpdated_by(UUID.randomUUID());

    Task savedTask = taskRepository.save(task);
    UUID taskId = savedTask.getId();

    Task findTask = taskRepository.findTaskById(taskId);
    assertThat(findTask).isEqualTo(task);
}
}
