package com.weg.reenginered.application.usecase.local;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.port.LocalPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveLocalUseCaseTest {

    @Mock
    private LocalPort localPort;

    @InjectMocks
    private SaveLocalUseCase saveLocalUseCase;

    @Test
    void execute_ShouldSaveLocalSuccessfully() {
        // Arrange
        Local local = new Local("Warehouse A", 1);
        Local savedLocal = new Local(1L, "Warehouse A", 1);
        when(localPort.save(local)).thenReturn(savedLocal);

        // Act
        Local result = saveLocalUseCase.execute(local);

        // Assert
        assertEquals(savedLocal, result);
        verify(localPort, times(1)).save(local);
    }
}
