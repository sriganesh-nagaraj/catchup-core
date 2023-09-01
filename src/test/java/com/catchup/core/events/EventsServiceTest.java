package com.catchup.core.events;

import com.catchup.core.adapters.persistance.fake.events.EventsFakeRepository;
import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.repositories.EventsRepository;
import com.catchup.core.events.serviceimpls.EventsServiceImpl;
import com.catchup.core.events.services.EventsService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventsServiceTest {

  private EventsService eventsService;

  private EventsRepository eventsRepository;

  public EventsServiceTest() {
    this.eventsRepository = new EventsFakeRepository();
    this.eventsService = new EventsServiceImpl(eventsRepository);
  }

  @BeforeEach
  void reset() {
    eventsRepository.deleteAll();
  }

  @Test
  void createEvent() {
    CreateEventRequest createEventRequest = new CreateEventRequest(
        "JUG monthly meetup", "Architecture and "
        + "stuff", LocalDateTime.parse("2023-09-02T04:00:00.000"),
        "1234");

    Event createdEvent = eventsService.createEvent(createEventRequest);
    Assertions.assertNotNull(createdEvent.id());
    Assertions.assertEquals(createdEvent.name(), createEventRequest.name());
    Assertions.assertEquals(createdEvent.description(),
        createEventRequest.description());
    Assertions.assertEquals(createdEvent.organizedBy()
        , createEventRequest.organizedBy());
    Assertions.assertEquals(createdEvent.scheduledAt(), createEventRequest.scheduledAt());
    Assertions.assertEquals(0, createdEvent.attendeesCount());
  }

  @Test
  void deleteEvent() {
    CreateEventRequest createEventRequest = new CreateEventRequest(
        "JUG monthly meetup", "Architecture and "
        + "stuff", LocalDateTime.parse("2023-09-02T04:00:00.000"),
        "1234");
    Event createdEvent = eventsService.createEvent(createEventRequest);

    eventsService.deleteEvent(createdEvent.id());

    Assertions.assertTrue(eventsRepository.getEventById(createdEvent.id()).isEmpty());
  }

  @Test
  void getAllEvents() {
    CreateEventRequest createEventRequest = new CreateEventRequest(
        "JUG monthly meetup", "Architecture and "
        + "stuff", LocalDateTime.parse("2023-09-02T04:00:00.000"),
        "1234");
    eventsService.createEvent(createEventRequest);
    eventsService.createEvent(createEventRequest);
    eventsService.createEvent(createEventRequest);

    List<Event> allEventsByCreator = eventsService.getAllEventsByCreator(
        "1234");

    Assertions.assertEquals(allEventsByCreator.size(), 3);
  }

}
