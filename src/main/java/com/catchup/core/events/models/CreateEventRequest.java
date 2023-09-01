package com.catchup.core.events.models;

import java.time.LocalDateTime;

public record CreateEventRequest(
    String name,
    String description,
    LocalDateTime scheduledAt,
    String organizedBy
) { }
