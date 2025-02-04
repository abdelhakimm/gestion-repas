package com.gestionrepas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTest {

    private Meal meal1;

    private Meal meal2;

    @BeforeEach
    public void setUp(){
        meal1 = new Meal();
        meal1.setId(1L).setName("Petit-dej");

        meal2 = new Meal();
        meal2.setId(1L).setName("Petit-dej");
    }
    @Test
    public void testMealEquals() {
        assertThat(meal1).isEqualTo(meal2);
    }

    @Test
    public void testMealEqualsWithoutID(){
        Schedule schedule1 = new Schedule();
        schedule1.setId(1L);


        assertThat(meal1.setSchedule(schedule1).setId(null))
                .isEqualTo( meal2.setSchedule(schedule1).setId(null));
    }

    @Test
    public void testMealHascode(){
        assertThat(meal1.hashCode()).isEqualTo(meal2.hashCode());
    }
}
