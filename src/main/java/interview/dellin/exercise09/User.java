package interview.dellin.exercise09;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author E.Bolgar on 05.06.2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
