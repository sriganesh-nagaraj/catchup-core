package com.catchup.core.adapters.persistance.fake.events;

import com.catchup.core.events.models.Event;
import com.catchup.core.events.repositories.EventsRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventsFakeRepository implements EventsRepository {

  private HashMap<String, Event> store;

  public EventsFakeRepository() {
    this.store = new HashMap<>();
  }

  @Override
  public Event saveEvent(Event event) {
    store.put(event.id(), event);
    return event;
  }

  @Override
  public void deleteEvent(String id) {
    store.remove(id);
  }

  @Override
  public List<Event> getAllEventsByCreator(String createdBy) {
    return store.values().stream()
        .filter(event -> event.organizedBy().equals(createdBy)).collect(
        Collectors.toList());
  }

  @Override
  public Optional<Event> getEventById(String id) {
    return Objects.isNull(store.get(id)) ? Optional.empty()
        : Optional.of(store.get(id));
  }

  @Override
  public void deleteAll() {
    this.store = new HashMap<>();
  }
}
