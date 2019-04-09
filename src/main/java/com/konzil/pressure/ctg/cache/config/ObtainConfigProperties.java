package com.konzil.pressure.ctg.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
      * @ClassName ObtainConfigProperties
      * @Description: 获取配置文件中redis相关的配置文件信息
      * @author MaXiaoPing
      * @date 2018/12/21 0021 下午 16:32
      **/
@Component
@Configuration
@ConfigurationProperties(prefix = "access")
@PropertySource("classpath:config/cache.properties")
public class ObtainConfigProperties {
 @Value("${access.list}")
 public String accessHost; //接入机IP
 @Value("${access.port}")
 public int accessPort; //接入机端口
 @Value("${access.num}")
 public int num; //接入机数量
 @Value("${access.pool.MaxIdle}")
 public int maxIdle; //最大空闲连接数
 @Value("${access.pool.MaxTotal}")
 public int maxTotal;    //最大连接数（空闲+使用中）
 @Value("${access.pool.MinIdle}")
 public int minIdle; //保持最小的空闲连接数
 @Value("${access.pool.setMaxWaitMillis}")
 public int maxWaitMillis;   //逐出连接的最小空闲时间
 @Value("${access.redis.Database}")
 public int database;    //桶位
 @Value("${access.redis.Password}")
 public String userAndPassword; //应用用户#密码
 @Value("${access.redis.Period}")
 public int period;  //后台监控执行周期，毫秒
 @Value("${access.redis.MonitorTimeout}")
 public int monitorTimeout;  //后台监控ping命令超时时间，毫秒

 public ObtainConfigProperties() {
 }

 public String getAccessHost() {
  return accessHost;
 }

 public void setAccessHost(String accessHost) {
  this.accessHost = accessHost;
 }

 public int getAccessPort() {
  return accessPort;
 }

 public void setAccessPort(int accessPort) {
  this.accessPort = accessPort;
 }

 public int getNum() {
  return num;
 }

 public void setNum(int num) {
  this.num = num;
 }

 public int getMaxIdle() {
  return maxIdle;
 }

 public void setMaxIdle(int maxIdle) {
  this.maxIdle = maxIdle;
 }

 public int getMaxTotal() {
  return maxTotal;
 }

 public void setMaxTotal(int maxTotal) {
  this.maxTotal = maxTotal;
 }

 public int getMinIdle() {
  return minIdle;
 }

 public void setMinIdle(int minIdle) {
  this.minIdle = minIdle;
 }

 public int getMaxWaitMillis() {
  return maxWaitMillis;
 }

 public void setMaxWaitMillis(int maxWaitMillis) {
  this.maxWaitMillis = maxWaitMillis;
 }

 public int getDatabase() {
  return database;
 }

 public void setDatabase(int database) {
  this.database = database;
 }

 public String getUserAndPassword() {
  return userAndPassword;
 }

 public void setUserAndPassword(String userAndPassword) {
  this.userAndPassword = userAndPassword;
 }

 public int getPeriod() {
  return period;
 }

 public void setPeriod(int period) {
  this.period = period;
 }

 public int getMonitorTimeout() {
  return monitorTimeout;
 }

 public void setMonitorTimeout(int monitorTimeout) {
  this.monitorTimeout = monitorTimeout;
 }

 @Override
 public String toString() {
  return "ObtainConfigProperties{" +
          "accessHost='" + accessHost + '\'' +
          ", accessPort=" + accessPort +
          ", num=" + num +
          ", maxIdle=" + maxIdle +
          ", maxTotal=" + maxTotal +
          ", minIdle=" + minIdle +
          ", maxWaitMillis=" + maxWaitMillis +
          ", database=" + database +
          ", userAndPassword='" + userAndPassword + '\'' +
          ", period=" + period +
          ", monitorTimeout=" + monitorTimeout +
          '}';
 }
}
