package com.boredblog.manager;

import com.boredblog.entity.Guest;
import com.boredblog.repository.GuestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("guest_fields")
    private String ignoredFields[];

    public Guest create(Guest guest) {
        return this.guestRepository.save(guest);
    }

    public Guest retrieve(Integer id) {
        return this.guestRepository.findOne(id);
    }

    /**
     * @note Unimplemented functionality.
     */
    public Guest update(Integer id, Guest guest) {
        Guest existingGuest = this.retrieve(id);
        BeanUtils.copyProperties(guest, existingGuest, this.ignoredFields);
        return this.guestRepository.save(existingGuest);
    }
}
