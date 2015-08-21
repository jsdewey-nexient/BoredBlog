package com.boredblog.entity;

import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the BaseEntity works as it should.
 */
public class BaseEntityTest {
    private final long CREATED_AT_TS = 1439218106000L; // Random long.
    private final long UPDATED_AT_TS = CREATED_AT_TS + 86400000; // Adds a day.
    private final Timestamp CREATED_AT = new Timestamp(CREATED_AT_TS);
    private final Timestamp UPDATED_AT = new Timestamp(UPDATED_AT_TS);
}
