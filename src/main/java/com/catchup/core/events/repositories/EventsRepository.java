package com.catchup.core.events.repositories;

import com.catchup.core.events.models.Event;
import java.util.List;
import java.util.Optional;

public interface EventsRepository {

  Event saveEvent(Event event);

  void deleteEvent(String id);

  List<Event> getAllEventsByCreator(String createdBy);

  Optional<Event> getEventById(String id);

  void deleteAll();

}
