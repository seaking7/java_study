package com.springtour.example.ch10redis.adapter.cache;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CacheAdapter {

    private final RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate;
    private final ValueOperations<HotelCacheKey, HotelCacheValue> hotelCacheOperation;

    public CacheAdapter(RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate) {
        this.hotelCacheRedisTemplate = hotelCacheRedisTemplate;
        this.hotelCacheOperation = hotelCacheRedisTemplate.opsForValue();
    }

    public void put(HotelCacheKey key, HotelCacheValue value) {
        hotelCacheOperation.set(key, value, Duration.ofSeconds(24 * 60 * 60));
    }

    public HotelCacheValue get(HotelCacheKey key) {
        return hotelCacheOperation.get(key);
    }

    public void delete(HotelCacheKey key) {
        hotelCacheRedisTemplate.delete(key);
    }
}
