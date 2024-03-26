package com.PP_3_1_2_CRUDspringBootmvc.Service;

import com.PP_3_1_2_CRUDspringBootmvc.dao.UserDAOImpl;
import com.PP_3_1_2_CRUDspringBootmvc.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAO;
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        logger.log(Level.INFO, "Showing all users");
        return userDAO.index();
    }

    @Override
    public User show(int id) {
        logger.log(Level.INFO, "Showing user with id {0}", id);
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        logger.log(Level.INFO, "Saving user: {0}", user);
        userDAO.save(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        logger.log(Level.INFO, "Updating user with id {0}: {1}", new Object[]{id, updatedUser});
        userDAO.update(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        logger.log(Level.INFO, "Deleting user with id {0}", id);
        userDAO.delete(id);
    }
}
