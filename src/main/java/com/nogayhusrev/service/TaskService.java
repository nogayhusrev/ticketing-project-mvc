package com.nogayhusrev.service;

import com.nogayhusrev.dto.TaskDTO;
import com.nogayhusrev.dto.UserDTO;
import com.nogayhusrev.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    List<TaskDTO> findAllTasksByStatus(Status status);

    void updateStatus(TaskDTO task);

}
