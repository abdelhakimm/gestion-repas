package com.gestionrepas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DishTest {

    private Dish dish1;

    private Dish dish2;

    @BeforeEach
    public void setUp(){
        dish1 = new Dish();
        dish1.setId(1L).setName("Lasagnes");
        dish2 = new Dish();
        dish2.setId(1L).setName("Lasagnes");
    }

    @Test
    public void testDishEquals(){
        assertThat(dish1).isEqualTo(dish2);
    }

    @Test
    public void testDishEqualsWithoutID(){
        assertThat(dish1.setId(null)).isEqualTo(dish2.setId(null));
    }

    @Test
    public void testDishHashCode(){
        assertThat(dish1.hashCode()).isEqualTo(dish2.hashCode());
    }
}
