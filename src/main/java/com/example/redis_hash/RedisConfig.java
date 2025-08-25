package com.example.redis_hash;

import com.example.redis_hash.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /*@Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // Create a new RedisTemplate instance
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // Set the connection factory
        template.setConnectionFactory(connectionFactory);

        // Configure the serializers
        // Use StringRedisSerializer for standard string keys
        template.setKeySerializer(new StringRedisSerializer());

        // Use StringRedisSerializer for hash keys (the field names within the hash)
        template.setHashKeySerializer(new StringRedisSerializer());

        // Use JdkSerializationRedisSerializer for the values, including User objects
        template.setValueSerializer(new JdkSerializationRedisSerializer());

        // Use JdkSerializationRedisSerializer for the hash values
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }*/

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory("127.0.0.1", 6379);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Use String serializer for keys and hash keys
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);

        // Use String serializer for values and hash values
        template.setValueSerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);

        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public HashOperations<String, String, String> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }
}
