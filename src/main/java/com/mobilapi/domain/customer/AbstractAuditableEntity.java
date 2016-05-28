package com.mobilapi.domain.customer;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.Version;

import java.util.Date;

public class AbstractAuditableEntity {

    @Id
    protected ObjectId id;

    protected Date creationDate;

    protected Date lastChange;

    @Version
    private long version;

    public AbstractAuditableEntity() {
        super();
    }

    public ObjectId getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastChange() {
        return lastChange;
    }

    @PrePersist
    public void prePersist() {
        this.creationDate = (creationDate == null) ? new Date() : creationDate;
        this.lastChange = (lastChange == null) ? creationDate : new Date();
    }

}
