package com.personal.webpage.User;

import java.time.LocalDateTime;

public record UserData(
    Integer uid,
    String username,
    String email,
    LocalDateTime createdAt
) {}