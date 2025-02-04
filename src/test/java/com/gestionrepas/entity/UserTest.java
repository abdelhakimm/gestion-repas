package com.gestionrepas.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {

    private User user1;
    private User user2;

    @BeforeEach
    public void setUp(){
       user1 = new User();
       user1.setId(1L).setUsername("abdel").setEmail("abdel@gmail.com");
       user2 = new User();
       user2.setId(1l).setUsername("abdel").setEmail("abdel@gmail.com");
    }

    @Test
    public void testUserEquals(){
        assertThat(user1).isEqualTo(user2);
    }

    @Test
    public void testUserEqualsWithoutId(){
        assertThat(user1.setId(null)).isEqualTo( user2.setId(null));
    }

    @Test
    public void testUserHashCode() {
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
    }
}
