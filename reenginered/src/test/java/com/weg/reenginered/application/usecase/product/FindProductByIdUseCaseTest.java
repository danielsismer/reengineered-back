package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.port.ProductPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindProductByIdUseCaseTest {

    @Mock
    private ProductPort productPort;

    @InjectMocks
    private FindProductByIdUseCase findProductByIdUseCase;

    @Test
    void execute_ShouldReturnProduct_WhenIdExists() {
        // Arrange
        Long productId = 1L;
        Product product = new Product(productId, "Apple", new BigDecimal("1.50"), null, "image_url", 10, "A red apple");
        when(productPort.findById(productId)).thenReturn(product);

        // Act
        Product result = findProductByIdUseCase.execute(productId);

        // Assert
        assertEquals(product, result);
        verify(productPort, times(1)).findById(productId);
    }
}
