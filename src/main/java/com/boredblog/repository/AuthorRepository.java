

package com.boredblog.repository;

import com.boredblog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Handles Author objects.
 */
@Service
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
