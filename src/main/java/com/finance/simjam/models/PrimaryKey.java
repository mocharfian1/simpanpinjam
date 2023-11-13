package com.finance.simjam.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.time.LocalDate;

public class PrimaryKey {
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBRangeKey(attributeName = "creationDate")
    private LocalDate creationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
