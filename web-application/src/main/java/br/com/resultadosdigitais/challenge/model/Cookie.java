package br.com.resultadosdigitais.challenge.model;

import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * The type User.
 */
@Entity
public class Cookie implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String uuid;

    @NotNull
    private String url;

    private Date datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = new Date();
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", url='" + url + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cookie)) return false;
        Cookie cookie = (Cookie) o;
        return Objects.equal(getId(), cookie.getId()) &&
                Objects.equal(getUuid(), cookie.getUuid()) &&
                Objects.equal(getUrl(), cookie.getUrl()) &&
                Objects.equal(getDatetime(), cookie.getDatetime());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getUuid(), getUrl(), getDatetime());
    }
}