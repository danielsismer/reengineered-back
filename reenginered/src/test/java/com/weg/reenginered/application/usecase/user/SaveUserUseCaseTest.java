package com.weg.reenginered.application.usecase.user;

import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.domain.port.UserPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveUserUseCaseTest {

    @Mock
    private UserPort userPort;

    @InjectMocks
    private SaveUserUseCase saveUserUseCase;

    @Test
    void execute_ShouldSaveUserSuccessfully() {
        // Arrange
        User user = new User("John Doe", "john@example.com", "password123");
        User savedUser = new User(1L, "John Doe", "john@example.com", "password123");
        when(userPort.save(user)).thenReturn(savedUser);

        // Act
        User result = saveUserUseCase.execute(user);

        // Assert
        assertEquals(savedUser, result);
        verify(userPort, times(1)).save(user);
    }
}
