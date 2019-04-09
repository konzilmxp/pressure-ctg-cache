package com.konzil.pressure.ctg.cache.util;

import com.ctg.itrdc.cache.pool.CtgJedisPool;
import com.ctg.itrdc.cache.pool.CtgJedisPoolConfig;
import com.konzil.pressure.ctg.cache.config.ObtainConfigProperties;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
      * @ClassName AccessPoolUtil
      * @Description: 接入机连接池工具类，得到一个接入机连接池的配置
      * @author MaXiaoPing
      * @date 2018/12/21 0021 下午 17:23
      **/
@Service
public class AccessPoolUtil {
    @Autowired
    private ObtainConfigProperties obtainConfigProperties;
    private Logger logger = LoggerFactory.getLogger(AccessPoolUtil.class);
    public CtgJedisPoolConfig getAccessPoolConfig(){
        /**
                 * @MethodName: getAccessConnectionPool
                 * @Deseription: 得到一个接入机连接池配置
                 * @Author: MaXiaoPing
                 * @CreateDate 2018/12/21 0021 下午 17:31
                 * @Version 0.0.1
                 **/
        List<HostAndPort> hostAndPortList= new ArrayList();
        String[] hostlist = obtainConfigProperties.getAccessHost().split(",");
        for(int i =0;i<obtainConfigProperties.getNum();i++){
            HostAndPort hostAndPort = new HostAndPort(hostlist[i],obtainConfigProperties.getAccessPort());
            System.out.println("接入机："+hostlist[i]);
            hostAndPortList.add(hostAndPort);
        }
        ////创建一个JedisPoolConfig的对象，并把引用值储存在GenericObjectPoolConfig的变量poolConfig中
        GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(obtainConfigProperties.getMaxIdle()); //最大空闲连接数
        poolConfig.setMaxTotal(obtainConfigProperties.getMaxTotal());   //最大连接数（空闲+使用中）
        poolConfig.setMinIdle(obtainConfigProperties.getMinIdle()); //保持最小的空闲连接数
        poolConfig.setMaxWaitMillis(obtainConfigProperties.getMaxWaitMillis()); //逐出连接的最小空闲时间
        //构造集团接入机连接对象
        CtgJedisPoolConfig ctgJedisPoolConfig = new CtgJedisPoolConfig(hostAndPortList);
        ctgJedisPoolConfig.setDatabase(obtainConfigProperties.getDatabase())    //桶位，根据分组不一样从管理平台上查询桶位
                .setPassword(obtainConfigProperties.getUserAndPassword())   //用户#密码
                .setPoolConfig(poolConfig)  //连接池
                .setPeriod(obtainConfigProperties.getPeriod())  //后台监控执行周期，毫秒
                .setMonitorTimeout(obtainConfigProperties.getMonitorTimeout()); //后台监控ping命令超时时间，毫秒
        //CtgJedisPool ctgJedisPool = new CtgJedisPool(ctgJedisPoolConfig);
        logger.info("得到接入机连接池配置成功");
        //return ctgJedisPool;
        return ctgJedisPoolConfig;
    }
}
