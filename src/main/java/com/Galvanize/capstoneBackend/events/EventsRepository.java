package com.Galvanize.capstoneBackend.events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Integer> {
}
