package br.com.resultadosdigitais.challenge.controller;

import br.com.resultadosdigitais.challenge.AbstractControllerTest;
import br.com.resultadosdigitais.challenge.model.User;
import br.com.resultadosdigitais.challenge.service.UserService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * The type User controller test.
 */
public class UserControllerTest extends AbstractControllerTest {

    @Mock
    private UserService service;

    @InjectMocks
    private UserController controller;

    private String uri = "/user";

    /**
     * Find all.
     *
     * @throws Exception the exception
     */
    @Test
    public void findAll() throws Exception {
        logger.info("> " + getMethodName());

        Collection<User> list = Collections.emptyList();
        when(service.findAll()).thenReturn(list);

        getMany(list, uri, HttpStatus.OK, true);

        verify(service, times(1)).findAll();
    }

    /**
     * Find by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void findById() throws Exception {
        logger.info("> " + getMethodName());

        Collection<User> userCollection = UserCollectionSetUp(true);

        when(service.findByUserId(id)).thenReturn(userCollection);

        getMany(userCollection, uri + "/{id}", id, HttpStatus.OK, true);

        verify(service, times(1)).findByUserId(id);
    }

    /**
     * Create user by form.
     *
     * @throws Exception the exception
     */
    @Test
    public void createUserByForm() throws Exception {
        logger.info("> " + getMethodName());
        User user = new User();
        when(service.create(any(User.class))).thenReturn(user);
        String inputJson = super.mapToJson(user);
        createOne(uri+"/track", inputJson, HttpStatus.CREATED, true);
        verify(service, times(1)).create(any(User.class));
    }
}