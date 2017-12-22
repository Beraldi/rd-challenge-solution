package br.com.resultadosdigitais.challenge.service;

import br.com.resultadosdigitais.challenge.AbstractTest;
import br.com.resultadosdigitais.challenge.model.Cookie;
import br.com.resultadosdigitais.challenge.repository.CookieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;

public class CookieServiceBeanTest extends AbstractTest {

    @Mock
    private Cookie cookie;

    @Mock
    private CookieRepository repository;

    @InjectMocks
    private CookieServiceBean service;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
    }

    private void FindAll(Boolean canFind){

        Collection<Cookie> cookieCollection;

        if(canFind) cookieCollection = CookieCollectionSetUp(true);
        else cookieCollection = new ArrayList<>();

        Collection<Cookie> list;

        doReturn(cookieCollection).when(jdbcTemplate).query(anyString(), (Object[]) anyObject(), any(RowMapper.class));
        doReturn(new ArrayList<Long>()).when(jdbcTemplate).queryForList(anyString());

        doReturn(cookieCollection).when(repository).findAll();

        list = service.findAll();

        Assert.assertNotNull("failure - expected not null", list);
        if(canFind) Assert.assertEquals("failure - expected different list size", cookieCollection.size(), list.size());
        else Assert.assertTrue("failure - expected empty list", list.isEmpty());

        verify(jdbcTemplate, times(1)).query(anyString(), (Object[]) anyObject(), any(RowMapper.class));
    }

    private void FindByCookieId(Boolean validId) {

        Collection<Cookie> returnedObject, object = CookieCollectionSetUp(true);

        String invalidId = UUID.randomUUID().toString();

        if(validId) doReturn(object).when(repository).findByCookieId(uuid);
        else doReturn(null).when(repository).findByCookieId(invalidId);

        returnedObject = service.findByCookieId(invalidId);

        if(validId) {
            Assert.assertNotNull("failure - expected not null", returnedObject);
            Assert.assertEquals("failure - expected returnedObject = object", returnedObject, object);
        }
        else
            Assert.assertNull("failure - expected null object", returnedObject);

        verify(repository, times(1)).findByCookieId(any(String.class));
    }

    private void Create(Boolean withoutId){
        Boolean notExpectedException = withoutId;
        Exception exception = null;

        Cookie returnedObject, object = CookieSetUp(true);

        if(withoutId){
            returnedObject = CookieSetUp(false);
            Assert.assertNull("failure - expected null", returnedObject.getUuid());
        }
        else returnedObject = CookieSetUp(true);

        doReturn(object).when(repository).save(any(Cookie.class));

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
            Assert.assertEquals("failure - expected returnedObject uuid", uuid, returnedObject.getUuid());
            Assert.assertEquals("failure - expected returnedObject = object", object, returnedObject);
            verify(repository, times(1)).save(any(Cookie.class));
        }
        else
            Assert.assertTrue("failure - expected Exception",
                    exception instanceof Exception);
    }



    private void Update(Boolean existingCookie, Boolean nonNullCookie){
        Boolean notExpectedException = existingCookie && nonNullCookie;

        Cookie object = CookieSetUp(true), returnedObject = null;
        CookieServiceBean spy = spy(service);
        Exception exception = null;

        doReturn(object).when(repository).save(any(object.getClass()));

        try {
            if(nonNullCookie) returnedObject = spy.update(object);
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
            verify(repository, times(1)).save(any(Cookie.class));
        }else
            Assert.assertTrue("failure - expected Exception",
                    exception instanceof Exception);
    }

    private void Delete(Boolean persisted){
        Boolean notExpectedException = persisted;
        Exception exception = null;

        Cookie object = CookieSetUp(true);
        CookieServiceBean spy = spy(service);

        try {
            spy.delete(uuid);
        } catch (Exception e) {
            exception = e;
            if(notExpectedException) System.out.println(exception.getMessage());
        }
        if(notExpectedException) {
            Assert.assertFalse("failure - not expected Exception",
                    exception != null);
            verify(repository, times(1)).save(any(Cookie.class));
        }
        else
            Assert.assertTrue("failure - expected Exception",
                    exception != null);
    }

    @Test
    public void findByCookieId() {
        logger.info("> " + getMethodName());

        FindByCookieId(true);
    }

    @Test
    public void findByCookieId_butCantFindAny() {
        logger.info("> " + getMethodName());

        FindByCookieId(true);
    }

    @Test
    public void findAll() {
        logger.info("> " + getMethodName());

        FindAll(true);
    }

    @Test
    public void findAll_butCantFindAny() {
        logger.info("> " + getMethodName());

        FindAll(false);
    }

    @Test
    public void create() {
        logger.info("> " + getMethodName());

        Create(true);
    }

    @Test
    public void create_withId() {
        logger.info("> " + getMethodName());

        Create(false);
    }

    @Test
    public void update_whenCookieDoesntExist() {
        logger.info("> " + getMethodName());

        Update(true, true);
    }

    @Test
    public void update_NullCookie() {
        logger.info("> " + getMethodName());

        Update(false, true);
    }

    @Test
    public void update() {
        logger.info("> " + getMethodName());

        Update(true, false);
    }

    @Test
    public void delete() {
        logger.info("> " + getMethodName());

        Delete(true);
    }

    @Test
    public void delete_NotPersistedCookie() {
        logger.info("> " + getMethodName());

        Delete(false);
    }
}