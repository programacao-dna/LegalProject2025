package io.americanas.legals.repository;

import io.americanas.legals.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {

    Event findByPrettyName(String prettyName);
}
