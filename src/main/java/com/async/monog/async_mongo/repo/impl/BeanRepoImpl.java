package com.async.monog.async_mongo.repo.impl;

import com.async.monog.async_mongo.model.TestBean;
import com.async.monog.async_mongo.repo.BeanRepo;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ReactiveRemoveOperation;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public class BeanRepoImpl implements BeanRepo {

    private final ReactiveMongoTemplate template;

    public BeanRepoImpl(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Flux<TestBean> getAll() {
        return template.findAll(TestBean.class);

    }

    @Override
    public void insertMany(List<TestBean> list) {
        template.insertAll(list)
                .subscribe();
    }

    @Override
    public void clear() {
        ReactiveRemoveOperation.ReactiveRemove<TestBean> remove = template.remove(TestBean.class);
        remove.all()
                .subscribe();
    }
}
