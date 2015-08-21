package com.boredblog.entity;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Tests created_at and updated_at.
 */
public abstract class BaseTimestampTest {
    protected final long CREATED_AT_TS = 1439218106000L; // Random long.
    protected final long UPDATED_AT_TS = CREATED_AT_TS + 86400000; // Adds a day.
    protected final Timestamp CREATED_AT = new Timestamp(CREATED_AT_TS);
    protected final Timestamp UPDATED_AT = new Timestamp(UPDATED_AT_TS);
}
