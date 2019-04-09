package com.konzil.pressure.ctg.cache.dao;

import com.ctg.itrdc.cache.pool.CtgJedisPool;
import com.ctg.itrdc.cache.pool.CtgJedisPoolException;
import com.ctg.itrdc.cache.pool.ProxyJedis;
import com.konzil.pressure.ctg.cache.util.AccessPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class OperationRedisDao {
    private static final Logger logger = LoggerFactory.getLogger(OperationRedisDao.class);
    //private AccessPoolUtil accessPoolUtil = new AccessPoolUtil();
    @Autowired
    private AccessPoolUtil accessPoolUtil;
    //public OperationRedisDao(AccessPoolUtil accessPoolUtil) {
        //this.accessPoolUtil = accessPoolUtil;
    //}

    public void test(){
        CtgJedisPool ctgJedisPool = new CtgJedisPool(accessPoolUtil.getAccessPoolConfig());
        ProxyJedis proxyJedis = null;
        //AccessPoolUtil accessPoolUtil = new AccessPoolUtil();
        for (int i = 1; i <= 1000000; i++) {
            try {
                proxyJedis = ctgJedisPool.getResource();
                String key1 = "key2" + i;
                String value = "valueDFFSDFLVMZnlknnnfafa" + i;
                proxyJedis.set(key1, value);
                //proxyJedis.close();
                //proxyJedis.get(key1);
                //System.out.println("key1"+proxyJedis.get(key1));
                proxyJedis.close();
            } catch (CtgJedisPoolException e) {
                logger.error("获取连接异常：" + e.getMessage());
            } finally {
                try {
                    //归还连接
                    proxyJedis.close();
                    Objects.requireNonNull(proxyJedis).close();
                } catch (Throwable e) {
                    logger.error(String.valueOf(e));
                }
            }
        }
        //关闭连接池
        ctgJedisPool.close();
    }
}
