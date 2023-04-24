package com.nogayhusrev.service.impl;

import com.nogayhusrev.dto.ProjectDTO;
import com.nogayhusrev.enums.Status;
import com.nogayhusrev.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {

        if(project.getProjectStatus()==null)
            project.setProjectStatus(Status.OPEN);

        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(),object);
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }
}