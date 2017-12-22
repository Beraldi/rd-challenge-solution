package br.com.resultadosdigitais.challenge.model;

import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * The type User.
 */
@Entity
@Table(name = "cookies")
public class Cookie implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String uuid;

    @NotNull
    private String url;

    @NotNull
    private Date datetime;

    /**
     * Instantiates a new Cookie.
     */
    public Cookie(){
        this.datetime = new Date();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets datetime.
     *
     * @return the datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * Sets datetime.
     *
     * @param datetime the datetime
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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