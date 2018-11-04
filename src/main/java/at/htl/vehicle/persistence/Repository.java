package at.htl.vehicle.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class Repository<T> implements Serializable {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> genericClass;

    public Repository(Class<T> genericClass) {
        this.genericClass = genericClass;
    }

    public T save(T entityObject) {
        return em.merge(entityObject);
    }

    public boolean delete(long id) {
        em.remove(em.getReference(genericClass, id));
        return true;
    }

    public T find(long id) {
        return em.find(genericClass, id);
    }

    public List<T> findAll() {
        return em
                .createQuery("select o from " + genericClass.getTypeName() + " o",genericClass)
                .getResultList();
    }
}
