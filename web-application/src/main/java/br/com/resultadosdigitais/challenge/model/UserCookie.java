package br.com.resultadosdigitais.challenge.model;

import com.google.common.base.Objects;

import java.util.Collection;

/**
 * The type User cookie.
 */
public class UserCookie {

    private User user;
    private Collection<Cookie> cookieCollection;

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets cookie collection.
     *
     * @return the cookie collection
     */
    public Collection<Cookie> getCookieCollection() {
        return cookieCollection;
    }

    /**
     * Sets cookie collection.
     *
     * @param cookieCollection the cookie collection
     */
    public void setCookieCollection(Collection<Cookie> cookieCollection) {
        this.cookieCollection = cookieCollection;
    }

    @Override
    public String toString() {
        return "UserCookie{" +
                "user=" + user +
                ", cookieCollection=" + cookieCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCookie)) return false;
        UserCookie that = (UserCookie) o;
        return Objects.equal(getUser(), that.getUser()) &&
                Objects.equal(getCookieCollection(), that.getCookieCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUser(), getCookieCollection());
    }
}
