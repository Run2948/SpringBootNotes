package com.borun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

// TODO: redis 集群配置
@Configuration
public class RedisConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String RedisNodes;

    @Bean
    public JedisCluster getJedisCluster() {
        String[] redisNodes = RedisNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String node : redisNodes) {
            String[] arr = node.split(":");
            HostAndPort hostAndPort = new HostAndPort(arr[0], Integer.parseInt(arr[1]));
            nodes.add(hostAndPort);
        }
        JedisCluster cluster = new JedisCluster(nodes);
        return cluster;
    }

}
