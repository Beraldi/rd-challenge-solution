package br.com.resultadosdigitais.challenge.model;

import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * The type User.
 */
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private Integer phone;

    @NotNull
    private String message;

    private Date datetime;

    /**
     * Gets datetime.
     *
     * @return Value of datetime.
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * Sets new datetime.
     *
     * @param datetime New value of datetime.
     */
    public void setDatetime(Date datetime) {
        this.datetime = new Date();
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets phone.
     *
     * @return Value of phone.
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * Sets new uuid.
     *
     * @param uuid New value of uuid.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new phone.
     *
     * @param phone New value of phone.
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new email.
     *
     * @param email New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets uuid.
     *
     * @return Value of uuid.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", message='" + message + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equal(getId(), user.getId()) &&
                Objects.equal(getUuid(), user.getUuid()) &&
                Objects.equal(getName(), user.getName()) &&
                Objects.equal(getEmail(), user.getEmail()) &&
                Objects.equal(getPhone(), user.getPhone()) &&
                Objects.equal(getMessage(), user.getMessage()) &&
                Objects.equal(getDatetime(), user.getDatetime());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getUuid(), getName(), getEmail(), getPhone(), getMessage(), getDatetime());
    }
}