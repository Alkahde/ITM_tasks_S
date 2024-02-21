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
        task.setId(UUID.fromString("2a00ba73-e04e-43f6-adb7-235ba26675ed"));
        task.setTitle("testTitle");
        task.setText("text");
        task.set_archived(false);
        task.setCreated(LocalDateTime.now());
        task.setCreated_by(UUID.randomUUID());
        task.setUpdated(LocalDateTime.now());
        task.setUpdated_by(UUID.randomUUID());

        taskRepository.save(task);

        Task findTask = taskRepository.findTaskById(task.getId());

        assertThat(findTask).isEqualTo(task);
    };

}
