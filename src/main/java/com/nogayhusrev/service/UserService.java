package com.nogayhusrev.service;

import com.nogayhusrev.dto.UserDTO;

import java.util.List;


public interface UserService extends CrudService<UserDTO,String> {

    List<UserDTO> findManagers();
}
