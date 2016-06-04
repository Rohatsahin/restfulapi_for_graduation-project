package com.mobilapi.repository;


import com.mobilapi.domain.customer.AbstractAuditableEntity;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericRepository<E extends AbstractAuditableEntity> {

    private final Class clazz;

    @Autowired
    private Datastore datastore;

    public GenericRepository(Class clazz) {
        this.clazz = clazz;
    }


    public String persist(E entity) {
        datastore.save(entity);
        return entity.getId();
    }

    public long count() {
        if (clazz == null) {
            return 0;
        }

        return datastore.find(clazz).countAll();
    }

    public E findByObjectId(final ObjectId id) {
        if ((clazz == null) || (id == null)) {
            return null;
        }

        return (E) datastore.find(clazz).filter("id", id).get();
    }


    public Datastore getDatastore() {
        return datastore;
    }
}
