package com.example.redis_hash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static final String KEY_PREFIX = "user:";

    @Autowired
    private HashOperations<String, String, String> hashOperations;

    // Save or update user fields
    public void saveUser(String id, Map<String, String> userData) {
        String key = KEY_PREFIX + id;
        hashOperations.putAll(key, userData);
    }

    // Get single field
    public String getUserField(String id, String field) {
        String key = KEY_PREFIX + id;
        return hashOperations.get(key, field);
    }

    // Get all fields
    public Map<String, String> getAllUser(String id) {
        String key = KEY_PREFIX + id;
        return hashOperations.entries(key);
    }

    // Delete field
    public void deleteUserField(String id, String field) {
        String key = KEY_PREFIX + id;
        hashOperations.delete(key, field);
    }

    // 🔥 Fetch multiple fields (HMGET)
    public Map<String, String> getUserFields(String id, List<String> fields) {
        String key = KEY_PREFIX + id;
        List<String> values = hashOperations.multiGet(key, fields);

        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < fields.size(); i++) {
            result.put(fields.get(i), values.get(i));
        }
        return result;
    }

    // Update an existing field or add a new field
    public void updateUserField(String id, String field, String value) {
        String key = KEY_PREFIX + id;
        hashOperations.put(key, field, value);
    }


}

