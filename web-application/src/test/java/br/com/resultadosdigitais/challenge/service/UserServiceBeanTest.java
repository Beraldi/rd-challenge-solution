package br.com.resultadosdigitais.challenge.service;

import br.com.resultadosdigitais.challenge.AbstractTest;
import br.com.resultadosdigitais.challenge.model.User;
import br.com.resultadosdigitais.challenge.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;

/**
 * The type User service bean test.
 */
public class UserServiceBeanTest extends AbstractTest {

    @Mock
    private User user;

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceBean service;

    @Mock
    private JdbcTemplate jdbcTemplate;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
    }

    private void FindAll(Boolean canFind){

        Collection<User> userCollection;

        if(canFind) userCollection = UserCollectionSetUp(true);
        else userCollection = new ArrayList<>();

        Collection<User> list;

        doReturn(userCollection).when(jdbcTemplate).query(anyString(), (Object[]) anyObject(), any(RowMapper.class));
        doReturn(new ArrayList<Long>()).when(jdbcTemplate).queryForList(anyString());

        doReturn(userCollection).when(repository).findAll();

        list = service.findAll();

        Assert.assertNotNull("failure - expected not null", list);
        if(canFind) Assert.assertEquals("failure - expected different list size", userCollection.size(), list.size());
        else Assert.assertTrue("failure - expected empty list", list.isEmpty());

        verify(jdbcTemplate, times(1)).query(anyString(), (Object[]) anyObject(), any(RowMapper.class));
    }

    private void FindByUserId(Boolean validId) {

        Collection<User> returnedObject, object = UserCollectionSetUp(true);

        Long invalidId = 2L;

        if(validId) doReturn(object).when(repository).findByUserId(id);
        else doReturn(null).when(repository).findByUserId(invalidId);

        returnedObject = service.findByUserId(invalidId);

        if(validId) {
            Assert.assertNotNull("failure - expected not null", returnedObject);
            Assert.assertEquals("failure - expected returnedObject = object", returnedObject, object);
        }
        else
            Assert.assertNull("failure - expected null object", returnedObject);

        verify(repository, times(1)).findByUserId(any(Long.class));
    }

    private void Create(Boolean withoutId){
        Boolean notExpectedException = withoutId;
        Exception exception = null;

        User returnedObject, object = UserSetUp(true);

        if(withoutId){
            returnedObject = UserSetUp(true);
            Assert.assertNull("failure - expected null", returnedObject.getId());
        }
        else returnedObject = UserSetUp(true);

        doReturn(object).when(repository).save(any(User.class));

        try {
            returnedObject = service.create(returnedObject);
        }
        catch (Exception e){
            exception = e;
            if(notExpectedException) System.out.println(exception.getMessage());
        }

        if(notExpectedException) {
            Assert.assertFalse("failure - not expected Exception",
                    exception != null);
            Assert.assertNotNull("failure - expected not null", returnedObject);
            Assert.assertEquals("failure - expected returnedObject id = 2", Long.valueOf(2), returnedObject.getId());
            Assert.assertEquals("failure - expected returnedObject = object", object, returnedObject);
            verify(repository, times(1)).save(any(User.class));
        }
        else
            Assert.assertTrue("failure - expected Exception",
                    exception instanceof Exception);
    }



    private void Update(Boolean existingUser, Boolean nonNullUser){
        Boolean notExpectedException = existingUser && nonNullUser;

        User object = UserSetUp(true), returnedObject = null;
        UserServiceBean spy = spy(service);
        Exception exception = null;

        doReturn(object).when(repository).save(any(object.getClass()));

        try {
            if(nonNullUser) returnedObject = spy.update(object);
            else returnedObject = spy.update(null);
        } catch (Exception e) {
            exception = e;
            if(notExpectedException) System.out.println(exception.getMessage());
        }

        if(notExpectedException) {
            Assert.assertFalse("failure - not expected Exception",
                    exception != null);
            Assert.assertNotNull("failure - expected not null", returnedObject);
            Assert.assertEquals("failure - expected returnedObject = object", object, returnedObject);
            verify(repository, times(1)).save(any(User.class));
        }else
            Assert.assertTrue("failure - expected Exception",
                    exception instanceof Exception);
    }

    private void Delete(Boolean persisted){
        Boolean notExpectedException = persisted;
        Exception exception = null;

        User object = UserSetUp(true);
        UserServiceBean spy = spy(service);

        try {
            spy.delete(2L);
        } catch (Exception e) {
            exception = e;
            if(notExpectedException) System.out.println(exception.getMessage());
        }
        if(notExpectedException) {
            Assert.assertFalse("failure - not expected Exception",
                    exception != null);
            verify(repository, times(1)).save(any(User.class));
        }
        else
            Assert.assertTrue("failure - expected Exception",
                    exception != null);
    }

    /**
     * Find by user id.
     */
    @Test
    public void findByUserId() {
        logger.info("> " + getMethodName());

        FindByUserId(true);
    }

    /**
     * Find by user id but cant find any.
     */
    @Test
    public void findByUserId_butCantFindAny() {
        logger.info("> " + getMethodName());

        FindByUserId(true);
    }

    /**
     * Find all.
     */
    @Test
    public void findAll() {
        logger.info("> " + getMethodName());

        FindAll(true);
    }

    /**
     * Find all but cant find any.
     */
    @Test
    public void findAll_butCantFindAny() {
        logger.info("> " + getMethodName());

        FindAll(false);
    }

    /**
     * Create.
     */
    @Test
    public void create() {
        logger.info("> " + getMethodName());

        Create(true);
    }

    /**
     * Create with id.
     */
    @Test
    public void create_withId() {
        logger.info("> " + getMethodName());

        Create(false);
    }

    /**
     * Update when user doesnt exist.
     */
    @Test
    public void update_whenUserDoesntExist() {
        logger.info("> " + getMethodName());

        Update(true, true);
    }

    /**
     * Update null user.
     */
    @Test
    public void update_NullUser() {
        logger.info("> " + getMethodName());

        Update(false, true);
    }

    /**
     * Update.
     */
    @Test
    public void update() {
        logger.info("> " + getMethodName());

        Update(true, false);
    }

    /**
     * Delete.
     */
    @Test
    public void delete() {
        logger.info("> " + getMethodName());

        Delete(true);
    }

    /**
     * Delete not persisted user.
     */
    @Test
    public void delete_NotPersistedUser() {
        logger.info("> " + getMethodName());

        Delete(false);
    }
}