package interview.dellin.exercise01;

/**
 * @author E.Bolgar on 15.03.2017.
 */
abstract class Entity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id != null ? id.equals(entity.id) : entity.id == null;
    }

    @Override
    public final int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
