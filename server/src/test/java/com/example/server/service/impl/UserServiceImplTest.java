package com.example.server.service.impl;

import com.example.server.dao.UserDAO;
import com.example.server.entity.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    UserDAO userDAO;

    @Autowired
    UserServiceImpl it;

    @ParameterizedTest
    @CsvSource(value = {"test,true","none, false"}, delimiter = ',')
    void testIsExist(String username, boolean expected) {
        User user = new User();
        when(userDAO.findByUsername("test")).thenReturn(user);
        assertThat(it.isExist(username), is(expected));
    }
}
