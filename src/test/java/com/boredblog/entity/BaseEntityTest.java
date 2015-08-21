package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the BaseEntity works as it should.
 */
public class BaseEntityTest {
    private final Integer ID = 1;
    private final long CREATED_AT_TS = 1439218106000L; // Random long.
    private final long UPDATED_AT_TS = CREATED_AT_TS + 86400000; // Adds a day.
    private final Timestamp CREATED_AT = new Timestamp(CREATED_AT_TS);
    private final Timestamp UPDATED_AT = new Timestamp(UPDATED_AT_TS);
    private BaseEntity baseEntity;

    @Before
    public void setup() throws Exception {
        this.baseEntity = new BaseEntity();

        this.baseEntity.setId(ID);
        this.baseEntity.setCreatedAt(CREATED_AT);
        this.baseEntity.setUpdatedAt(UPDATED_AT);
    }

    @Test
    public void testIdMatches() {
        Integer result = this.baseEntity.getId();

        assertEquals(
                "testIdMatches did not receive the ID that was set.",
                ID,
                result
        );
    }

    @Test
    public void testCreatedAtMatches() {
        Timestamp result = this.baseEntity.getCreatedAt();

        assertEquals(
                "testCreatedAtMatches did not receive the Timestamp " +
                    "that was set.",
                CREATED_AT,
                result
                );
    }

    @Test
    public void testUpdatedAtMatches() {
        assertEquals(
                "testUpdatedAtMatches did not receive the Timestamp " +
                        "that was set.",
                UPDATED_AT,
                this.baseEntity.getUpdatedAt()
        );
    }
}
