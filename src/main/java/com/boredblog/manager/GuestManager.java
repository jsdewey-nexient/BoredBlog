package com.boredblog.manager;

import com.boredblog.entity.Guest;
import com.boredblog.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Handles Guest objects.
 */
@Service
public class GuestManager {
    @Autowired
    private GuestRepository guestRepository;

    public Guest create(Guest guest) {
        return this.guestRepository.save(guest);
    }

    public Guest retrieve(Integer id) {
        return this.guestRepository.findOne(id);
    }

    public Guest update(Guest guest) {
        return this.create(guest);
    }
}
