package br.com.resultadosdigitais.challenge;

import br.com.resultadosdigitais.challenge.model.Cookie;
import br.com.resultadosdigitais.challenge.model.User;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

/**
 * The br.com.resultadosdigitais.challenge.AbstractTest class is the parent of all JUnit test classes. This class
 * configures the test ApplicationContext and test runner environment.
 *
 * @author Matt Warman Created by beraldi on 31/10/16.
 */
@RunWith(PowerMockRunner.class)
public abstract class AbstractTest {

    /**
     * The Id.
     */
    protected Long id = 1L;

    /**
     * The Uuid.
     */
    protected String uuid = UUID.randomUUID().toString();

    /**
     * The Logger instance for all classes in the unit test framework.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Gets method name.
     *
     * @return the method name
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * Cookie set up cookie.
     *
     * @param hasId the has id
     * @return the cookie
     */
    protected Cookie CookieSetUp(boolean hasId) {
        Cookie cookie = new Cookie();

        if(hasId) cookie.setUuid(uuid);

        return cookie;
    }

    /**
     * Cookie collection set up collection.
     *
     * @param hasId the has id
     * @return the collection
     */
    protected Collection<Cookie> CookieCollectionSetUp(Boolean hasId){
        Collection<Cookie> cookieCollection = new ArrayList<>(Arrays.asList(new Cookie(), new Cookie(), new Cookie(), new Cookie()));
        Cookie cookie = new Cookie();

        if(hasId) {
            cookie.setUuid(uuid);
        }else {
            cookie.setUuid(UUID.randomUUID().toString());
        }

        cookieCollection.add(cookie);


        return cookieCollection;
    }

    /**
     * User set up user.
     *
     * @param hasId the has id
     * @return the user
     */
    protected User UserSetUp(boolean hasId) {
        User user = new User();

        if(hasId) user.setId(id);

        return user;
    }

    /**
     * User collection set up collection.
     *
     * @param hasId the has id
     * @return the collection
     */
    protected Collection<User> UserCollectionSetUp(Boolean hasId){
        Collection<User> userCollection = new ArrayList<>(Arrays.asList(new User(), new User(), new User(), new User()));
        User user = new User();

        if(hasId) {
            user.setId(id);
        }else {
            user.setId(5L);
        }

        userCollection.add(user);


        return userCollection;
    }

}