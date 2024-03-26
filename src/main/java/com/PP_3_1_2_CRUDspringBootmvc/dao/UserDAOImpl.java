package com.PP_3_1_2_CRUDspringBootmvc.dao;


import com.PP_3_1_2_CRUDspringBootmvc.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> index() {
        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        User userToBeUpdated = entityManager.find(User.class, id);

        if (userToBeUpdated != null) {
            userToBeUpdated.setName(updatedUser.getName());
            userToBeUpdated.setAge(updatedUser.getAge());
            userToBeUpdated.setEmail(updatedUser.getEmail());
            entityManager.merge(userToBeUpdated);
        }
    }

    @Transactional
    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }
}
