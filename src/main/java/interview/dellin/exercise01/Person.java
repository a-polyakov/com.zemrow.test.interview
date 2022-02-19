package interview.dellin.exercise01;

import java.util.Date;

/**
 * @author E.Bolgar on 15.03.2017.
 */
class Person extends Entity{
    private String family;

    private String name;

    private Date birth;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(getId());
        sb.append(", family=").append(family);
        sb.append(", name=").append(name);
        sb.append(", birth=").append(birth);
        sb.append('}');
        return sb.toString();
    }
}
