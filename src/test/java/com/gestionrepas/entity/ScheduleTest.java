package com.gestionrepas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ScheduleTest {

    private Schedule sch1;
    private Schedule sch2;

    @BeforeEach
    public void setUp(){
        sch1 = new Schedule();
        sch2 = new Schedule();

        sch1.setId(1L).setName("repas mardi midi").
                setStartDate(LocalDate.of(2025,02,03)).
                setEndDate(LocalDate.of(2025,02,04));
        sch2.setId(1L).setName("repas mardi midi").
                setStartDate(LocalDate.of(2025,02,03)).
                setEndDate(LocalDate.of(2025,02,04));
    }

    @Test
    public void testScheduleEquals(){
        assertThat(sch1).isEqualTo(sch2);
    }

    @Test
    public void testScheduleEqulasWithoutId(){
        assertThat(sch1.setId(null)).isEqualTo(sch2.setId(null));

    }

    @Test
    public void testScheduleHashCode(){
        assertThat(sch1.hashCode()).isEqualTo(sch2.hashCode());
    }

}
