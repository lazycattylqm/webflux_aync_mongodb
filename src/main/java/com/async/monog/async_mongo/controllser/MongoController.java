package com.async.monog.async_mongo.controllser;

import com.async.monog.async_mongo.service.BeanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

    private final BeanService service;

    public MongoController(BeanService service) {
        this.service = service;

    }

    @GetMapping("/many")
    public void many() {
        service.generateMany();
    }

    @GetMapping("/show")
    public void show() {
        service.showAll();
    }

    @GetMapping("/clear")
    public void clear() {
        service.clear();
    }
}
