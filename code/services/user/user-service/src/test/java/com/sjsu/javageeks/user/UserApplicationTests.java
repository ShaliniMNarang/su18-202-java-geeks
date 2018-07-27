package com.sjsu.javageeks.user;

import com.sjsu.javageeks.user.model.User;
import com.sjsu.javageeks.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	@Mock
	UserService userService;

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setUserName("jdoe");
		user.setPassword("Welcome1");
		user.setPhone("408-915-0000");
		user.setEmail("jdoe@gmail.com");

		 when(userService.saveUser(user)).thenReturn(Optional.ofNullable(user));
		 Optional<User> savedUser = userService.saveUser(user);

		assertTrue(savedUser.isPresent());
	}

	@Test
	public void testDeleteAllUsers() {
		userService.deleteAllUsers();
		List<User> users = userService.getUsers();

		assertTrue(users.isEmpty());


	}
    @Test
    public void testListAllUsers() {

        List<User> users = userService.getUsers();
        System.out.println(users);

        assertTrue(users.isEmpty());


    }

}
