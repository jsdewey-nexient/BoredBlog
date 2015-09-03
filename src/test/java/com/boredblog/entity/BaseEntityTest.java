package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the BaseEntity works as it should.
 */
public class BaseEntityTest extends BaseTimestampTest {
    private final Integer ID = 1;
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
