package org.zapto.trywithfun.sbrestapi.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.zapto.trywithfun.sbrestapi.entity.ApplicationUser;
import org.zapto.trywithfun.sbrestapi.service.ApplicationUserService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private ApplicationUserService applicationUserService;

    @Mock
    private Pageable pageable;
    @Mock
    private ApplicationUser user;

    private static final String LOGIN = "login";

    @Test
    void list() {
        userController.list(pageable);
        verify(applicationUserService).listView(pageable);
        verifyNoMoreInteractions(applicationUserService);
    }

    @Test
    void get() {
        userController.get(LOGIN);
        verify(applicationUserService).getByLoginView(LOGIN);
        verifyNoMoreInteractions(applicationUserService);
    }

    @Test
    void create() {
        userController.create(user);
        verify(applicationUserService).create(user);
        verifyNoMoreInteractions(applicationUserService);
    }

    @Test
    void update() {
        userController.update(LOGIN, user);
        verify(applicationUserService).update(LOGIN, user);
        verifyNoMoreInteractions(applicationUserService);
    }

    @Test
    void delete() {
        userController.delete(LOGIN);
        verify(applicationUserService).delete(LOGIN);
        verifyNoMoreInteractions(applicationUserService);
    }
}