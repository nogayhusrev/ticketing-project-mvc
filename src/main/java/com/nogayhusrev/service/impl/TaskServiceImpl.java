package com.nogayhusrev.service.impl;

import com.nogayhusrev.dto.TaskDTO;
import com.nogayhusrev.dto.UserDTO;
import com.nogayhusrev.enums.Status;
import com.nogayhusrev.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO task) {

        if (task.getTaskStatus() == null)
            task.setTaskStatus(Status.OPEN);

        if (task.getAssignedDate() == null)
            task.setAssignedDate(LocalDate.now());

        if (task.getId() == null)
            task.setId(UUID.randomUUID().getMostSignificantBits());

        return super.save(task.getId(), task);

    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO task) {

        TaskDTO foundTask = findById(task.getId());

        task.setTaskStatus(foundTask.getTaskStatus());
        task.setAssignedDate(foundTask.getAssignedDate());

        super.update(task.getId(), task);

    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream()
                .filter(task -> task.getProject().getAssignedManager().equals(manager))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> !task.getTaskStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO task) {
        findById(task.getId()).setTaskStatus(task.getTaskStatus());
    }

}
