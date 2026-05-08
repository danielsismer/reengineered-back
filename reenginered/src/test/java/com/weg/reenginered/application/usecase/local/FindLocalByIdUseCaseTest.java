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
class FindLocalByIdUseCaseTest {

    @Mock
    private LocalPort localPort;

    @InjectMocks
    private FindLocalByIdUseCase findLocalByIdUseCase;

    @Test
    void execute_ShouldReturnLocal_WhenIdExists() {
        // Arrange
        Long localId = 1L;
        Local local = new Local(localId, "Warehouse A", 1);
        when(localPort.listById(localId)).thenReturn(local);

        // Act
        Local result = findLocalByIdUseCase.execute(localId);

        // Assert
        assertEquals(local, result);
        verify(localPort, times(1)).listById(localId);
    }
}
