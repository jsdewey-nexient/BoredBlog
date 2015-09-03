

package com.boredblog.repository;

import com.boredblog.entity.Author;
import org.springframework.stereotype.Repository;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Handles Author objects.
 */
@Repository
public interface AuthorRepository extends BaseRepository<Author, Integer> {
}
