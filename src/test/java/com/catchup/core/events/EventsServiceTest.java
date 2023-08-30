package com.catchup.core.events;

import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.serviceimpls.EventsServiceImpl;
import com.catchup.core.events.services.EventsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventsServiceTest {

  private EventsService eventsService;

  public EventsServiceTest() {
    this.eventsService = new EventsServiceImpl(event -> event);
  }

  @Test
  void createEvent() {
    CreateEventRequest createEventRequest = new CreateEventRequest("JUG "
        + "Catchup", "Wassup!");

    Event createdEvent = eventsService.createEvent(createEventRequest);
    Assertions.assertNotNull(createdEvent.id());
    Assertions.assertEquals(createdEvent.name(), createEventRequest.name());
    Assertions.assertEquals(createdEvent.description(),
        createEventRequest.description());
  }

}
