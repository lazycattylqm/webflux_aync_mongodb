package com.async.monog.async_mongo.service.impl;

import com.async.monog.async_mongo.model.TestBean;
import com.async.monog.async_mongo.repo.BeanRepo;
import com.async.monog.async_mongo.service.BeanService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Stream;

@Service
public class BeanServiceImpl implements BeanService {

    private final BeanRepo repo;

    public BeanServiceImpl(BeanRepo repo) {
        this.repo = repo;
    }

    @Override public void showAll() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        repo.getAll()
                .subscribe(System.out::println);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Override public void generateMany() {
        Stream.iterate(0, i -> i + 1)
                .limit(1000)
                .forEach(i -> {
                    List<TestBean> testBeans = randomMany();
                    repo.insertMany(testBeans);
                });
    }

    @Override public void clear() {
        repo.clear();
    }

    private List<TestBean> randomMany() {
        return Stream.iterate(0, i -> i + 1)
                .limit(1000)
                .map(i -> {
                    String random = RandomStringUtils.random(10, true, false);
                    TestBean testBean = new TestBean();
                    testBean.setDesc(random);
                    return testBean;
                })
                .toList();

    }
}
