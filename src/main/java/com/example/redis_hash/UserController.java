package com.example.redis_hash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users") // Base path for all user-related endpoints
public class UserController {

    @Autowired
    private UserService userService;

    // Save or update user data
    @PostMapping("/{id}")
    public String saveUser(@PathVariable String id, @RequestBody Map<String, String> userData) {
        userService.saveUser(id, userData);
        return "User " + id + " saved/updated successfully.";
    }

    // Get a single field
    @GetMapping("/{id}/{field}")
    public String getUserField(@PathVariable String id, @PathVariable String field) {
        return userService.getUserField(id, field);
    }

    // Get all fields
    @GetMapping("/{id}")
    public Map<String, String> getAllUser(@PathVariable String id) {
        return userService.getAllUser(id);
    }

    // Delete a field
    @DeleteMapping("/{id}/{field}")
    public String deleteUserField(@PathVariable String id, @PathVariable String field) {
        userService.deleteUserField(id, field);
        return "Field '" + field + "' deleted from user " + id;
    }

    // 🔥 Get multiple fields (HMGET)
    @GetMapping("/{id}/fields")
    public Map<String, String> getUserFields(@PathVariable String id, @RequestParam String fields) {
        List<String> fieldList = Arrays.asList(fields.split(","));
        return userService.getUserFields(id, fieldList);
    }

    // Update existing field OR add new field
    @PutMapping("/{id}/{field}")
    public String updateUserField(@PathVariable String id,
                                  @PathVariable String field,
                                  @RequestBody String value) {
        userService.updateUserField(id, field, value);
        return "Field '" + field + "' updated for user " + id;
    }

}
