package com.boredblog.repository;

import com.boredblog.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Responsible for handling Guests.
 */
public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
