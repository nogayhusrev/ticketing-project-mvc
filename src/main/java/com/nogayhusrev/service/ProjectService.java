package com.nogayhusrev.service;

import com.nogayhusrev.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO,String>{

    void complete(ProjectDTO project);
}
