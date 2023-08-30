package com.catchup.core.events.models;

import java.time.LocalDateTime;

public record Event(
    String id,
    String name,
    String description) {

}
