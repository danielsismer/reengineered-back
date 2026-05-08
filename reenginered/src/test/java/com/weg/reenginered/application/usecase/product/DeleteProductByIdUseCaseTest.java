package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.port.ProductPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteProductByIdUseCaseTest {

    @Mock
    private ProductPort productPort;

    @InjectMocks
    private DeleteProductByIdUseCase deleteProductByIdUseCase;

    @Test
    void execute_ShouldDeleteProductSuccessfully() {
        // Arrange
        Long productId = 1L;
        doNothing().when(productPort).deleteById(productId);

        // Act
        deleteProductByIdUseCase.execute(productId);

        // Assert
        verify(productPort, times(1)).deleteById(productId);
    }
}
