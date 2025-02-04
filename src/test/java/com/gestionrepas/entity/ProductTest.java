package com.gestionrepas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    private Product p1;
    private Product p2;

    @BeforeEach
    public void setUp(){
        p1 = new Product();
        p1.setId(1L).setName("Oeufs");

        p2 = new Product();
        p2.setId(1L).setName("Oeufs");
    }

    @Test
    public void testProductEquals(){
        assertThat(p1).isEqualTo(p2);
    }

    @Test
    public void testProductEqualsWihtoutId(){
        Store store = new Store();
        store.setId(1L);
        assertThat(p1.setStore(store).setId(null)).isEqualTo(p2.setStore(store).setId(null));
    }

    @Test
    public void testProductHashCode(){
        assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
    }
}
