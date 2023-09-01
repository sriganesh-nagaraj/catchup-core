package com.catchup.core.events.services;

import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.models.UpdateEventRequest;
import common.exceptions.ValidationException;
import java.util.List;

public interface EventsService {
  Event createEvent(CreateEventRequest createEventRequest);

  void deleteEvent(String id);

  Event updateEvent(UpdateEventRequest updateEventRequest)
      throws ValidationException;

  List<Event> getAllEventsByCreator(String createdBy);
}
