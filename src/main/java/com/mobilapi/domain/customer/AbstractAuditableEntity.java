package com.mobilapi.domain.customer;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.Version;

import java.util.Date;

public class AbstractAuditableEntity {

    @Id
    private ObjectId id;

    private Date creationDate;

    private Date lastChange;

    @Version
    private long version;

    public AbstractAuditableEntity() {
        super();
    }

    public String getId() {
        return id.toString();
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
