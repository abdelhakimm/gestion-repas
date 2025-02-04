package com.gestionrepas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {

    private Store st1;
    private Store st2;

    @BeforeEach
    public void setUp(){
        st1= new Store();
        st1.setId(1L).setName("Aldi");
        st2= new Store();
        st2.setId(1L).setName("Aldi");

    }

    @Test
    public void testStoreEquals(){
        assertThat(st1).isEqualTo(st2);
    }

    @Test
    public void testStoreEqualsWithoutId(){
        assertThat(st1.setId(null)).isEqualTo(st2.setId(null));
    }

    @Test
    public void testStoreHashCode(){
        assertThat(st1.hashCode()).isEqualTo(st2.hashCode());
    }
}
