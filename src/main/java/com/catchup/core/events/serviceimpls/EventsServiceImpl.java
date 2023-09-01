package com.catchup.core.events.serviceimpls;

import com.catchup.core.events.models.CreateEventRequest;
import com.catchup.core.events.models.Event;
import com.catchup.core.events.models.UpdateEventRequest;
import com.catchup.core.events.repositories.EventsRepository;
import com.catchup.core.events.services.EventsService;
import common.exceptions.ExceptionMessages;
import common.exceptions.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventsServiceImpl implements EventsService {

  private EventsRepository eventsRepository;
  public EventsServiceImpl(EventsRepository eventsRepository) {
    this.eventsRepository = eventsRepository;
  }

  @Override
  public Event createEvent(CreateEventRequest createEventRequest) {
    return eventsRepository.saveEvent(new Event(UUID.randomUUID().toString(),
     createEventRequest.name(), createEventRequest.description(),
        createEventRequest.scheduledAt(), createEventRequest.organizedBy(),
        0L));
  }

  @Override
  public void deleteEvent(String id) {
    eventsRepository.deleteEvent(id);
  }

  @Override
  public Event updateEvent(UpdateEventRequest updateEventRequest)
      throws ValidationException {
    Optional<Event> optionalEvent =
        eventsRepository.getEventById(updateEventRequest.id());
    if (!optionalEvent.isPresent()) {
      throw new ValidationException(ExceptionMessages.EVENT_NOT_FOUND);
    }
    Event event = optionalEvent.get();
    Event updatedEvent = new Event(updateEventRequest.id(),
        updateEventRequest.name(), updateEventRequest.description(),
        updateEventRequest.scheduledAt(), event.organizedBy(),
        event.attendeesCount());
    return eventsRepository.saveEvent(updatedEvent);
  }

  @Override
  public List<Event> getAllEventsByCreator(String createdBy) {
    return eventsRepository.getAllEventsByCreator(createdBy);
  }


}
