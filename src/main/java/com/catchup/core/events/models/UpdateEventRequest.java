package com.catchup.core.events.models;

import java.time.LocalDateTime;

public record UpdateEventRequest(
    String id,
    String name,
    String description,
    LocalDateTime scheduledAt
) { }
