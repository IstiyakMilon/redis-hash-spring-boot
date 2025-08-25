# redis-hash-spring-boot
A simple Spring Boot + Redis application demonstrating how to use Redis Hashes for storing and managing user data.
The project provides REST APIs to:

- Create/Update a user with multiple fields (name, age, email, phone, gender)

- Fetch all fields of a user (HGETALL)

- Fetch a single field (HGET)

- Fetch multiple fields (HMGET)

- Update or add a new field to an existing user (HSET)

- Delete a field (HDEL)
