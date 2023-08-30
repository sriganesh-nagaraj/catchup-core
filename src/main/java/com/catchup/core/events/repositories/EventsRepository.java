package com.catchup.core.events.repositories;

import com.catchup.core.events.models.Event;

public interface EventsRepository {

  Event saveEvent(Event event);

}
