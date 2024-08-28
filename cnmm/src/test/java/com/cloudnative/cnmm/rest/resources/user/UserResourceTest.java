package com.cloudnative.cnmm.rest.resources.user;

import com.cloudnative.cnmm.data.models.user.User;
import com.cloudnative.cnmm.data.models.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserResourceTest {

    Map<String, Double> scores = Collections.singletonMap("Category", 2.5);
    User user = new User("John", "Smith", "Big Company", scores);

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserResource userResource;

    @Test
    public void testGetUserById() {
        user.setId("1");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));
        assertEquals(userResource.getUserByID("1").getBody(), user);
        assertNull(userResource.getUserByID("2").getBody());
    }

    @Test
    public void testGetUserByFullNameAndCompany() {
        when(userRepository.findByFirstNameAndLastName(user.firstName, user.lastName))
                .thenReturn(user);
        assertEquals(userResource.getUserByFullName(user.firstName, user.lastName).getBody(), user);
        assertNull(userResource.getUserByFullName("Jane", "Doe").getBody());
    }

    @Test
    public void testSaveUser() {
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(userResource.saveUser(user).getBody(), user);
    }

    @Test
    public void testDeleteUser() {
        userResource.deleteUser("1");
        verify(userRepository, atLeastOnce()).deleteById("1");
    }

}
