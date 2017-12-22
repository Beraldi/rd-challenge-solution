package br.com.resultadosdigitais.challenge.service;

import br.com.resultadosdigitais.challenge.model.User;
import br.com.resultadosdigitais.challenge.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * The type User service bean.
 */
@Service
public class UserServiceBean implements UserService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> findByUserId(long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(this.findByUserId(id));
    }
}
