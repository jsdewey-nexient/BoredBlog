package com.boredblog.repository;

import com.boredblog.entity.Guest;
import org.springframework.stereotype.Repository;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Responsible for handling Guests.
 */
@Repository
public interface GuestRepository extends BaseRepository<Guest, Integer> {
}
