package com.konzil.pressure.ctg.cache;

import com.konzil.pressure.ctg.cache.dao.OperationRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PressureCtgCacheApplication implements CommandLineRunner {
    @Autowired
    private OperationRedisDao operationRedisDao;
    public static void main(String[] args) {
        SpringApplication.run(PressureCtgCacheApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       operationRedisDao.test();
    }
}

