package com.catchup.core.events.serviceimpls;

import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.repositories.EventsRepository;
import com.catchup.core.events.services.EventsService;
import java.util.UUID;

public class EventsServiceImpl implements EventsService {

  private EventsRepository eventsRepository;
  public EventsServiceImpl(EventsRepository eventsRepository) {
    this.eventsRepository = eventsRepository;
  }

  @Override
  public Event createEvent(CreateEventRequest createEventRequest) {
    return eventsRepository.saveEvent(new Event(UUID.randomUUID().toString(),
     createEventRequest.name(), createEventRequest.description()));
  }

}
