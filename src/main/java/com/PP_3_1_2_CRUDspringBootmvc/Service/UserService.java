package com.PP_3_1_2_CRUDspringBootmvc.Service;

import com.PP_3_1_2_CRUDspringBootmvc.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    public void delete(int id);
}
