package com.nogayhusrev.service;

import com.nogayhusrev.dto.ProjectDTO;
import com.nogayhusrev.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}
