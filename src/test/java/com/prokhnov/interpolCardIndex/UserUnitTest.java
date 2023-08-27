package com.prokhnov.interpolCardIndex;

import com.prokhnov.interpolCardIndex.configuration.UnitTestConfiguration;
import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.repository.UserRepository;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class UserUnitTest extends UnitTestConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DataSet("user_data/current_user.yml")
    @ExpectedDataSet("user_data/delete_user.yml")
    public void testShouldDeleteUserById() throws Exception {
        userRepository.deleteById(2L);

        assertEquals(1, userRepository.count());
    }

    @Test
    @DataSet(executeScriptsBefore = "ddl_user.sql")
    @ExpectedDataSet("user_data/add_user.yml")
    public void testShouldAddUser() {
        User user = User.builder()
                .email("supplier@example.com")
                .password("supplier")
                .username("supplier")
                .enabled(false)
                .build();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    @DataSet("user_data/current_user.yml")
    @ExpectedDataSet("user_data/update_user.yml")
    public void testShouldUpdateUserById() throws Exception {
        User user;
        if (userRepository.findById(2L).isPresent()) {
            user = userRepository.findById(2L).get();
        } else {
            throw new Exception();
        }
        user.setUsername("admin2");
        userRepository.save(user);

        assertEquals(2, userRepository.count());
    }
}


