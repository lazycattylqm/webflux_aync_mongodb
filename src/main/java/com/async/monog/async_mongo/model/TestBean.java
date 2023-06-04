package com.async.monog.async_mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "test")
public class TestBean {
    private String id;

    @Field("test")
    private String desc;
}
