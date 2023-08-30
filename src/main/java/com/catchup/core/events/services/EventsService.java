package com.catchup.core.events.services;

import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;

public interface EventsService {
  Event createEvent(CreateEventRequest createEventRequest);
}
