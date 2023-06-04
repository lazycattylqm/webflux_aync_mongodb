package com.async.monog.async_mongo.repo;

import com.async.monog.async_mongo.model.TestBean;
import reactor.core.publisher.Flux;

import java.util.List;

public interface BeanRepo {
    Flux<TestBean> getAll();

    void insertMany(List<TestBean> list);

    void clear();
}
