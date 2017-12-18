package br.com.resultadosdigitais.challenge.model;

import com.google.common.base.Objects;

import java.util.Date;
import java.util.UUID;

/**
 * The type User.
 */
public class User {

    private UUID id;
    private String url;
    private Date dateTime;
    private String email;

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param url      the url
     * @param dateTime the date time
     * @param email    the email
     */
    public User(UUID id, String url, Date dateTime, String email) {
        this.id = id;
        this.url = url;
        this.dateTime = dateTime;
        this.email = email;
    }

    /**
     * Instantiates a new User.
     *
     * @param url      the url
     * @param dateTime the date time
     * @param email    the email
     */
    public User(String url, Date dateTime, String email) {
        this.id = UUID.randomUUID();
        this.url = url;
        this.dateTime = dateTime;
        this.email = email;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets dateTime.
     *
     * @return Value of dateTime.
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Sets new url.
     *
     * @param url New value of url.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets url.
     *
     * @return Value of url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets new dateTime.
     *
     * @param dateTime New value of dateTime.
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", dateTime=" + dateTime +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equal(getId(), user.getId()) &&
                Objects.equal(getUrl(), user.getUrl()) &&
                Objects.equal(getDateTime(), user.getDateTime()) &&
                Objects.equal(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getUrl(), getDateTime(), getEmail());
    }
}