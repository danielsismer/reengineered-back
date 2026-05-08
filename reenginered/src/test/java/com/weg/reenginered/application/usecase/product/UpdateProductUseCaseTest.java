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
class UpdateProductUseCaseTest {

    @Mock
    private ProductPort productPort;

    @InjectMocks
    private UpdateProductUseCase updateProductUseCase;

    @Test
    void execute_ShouldUpdateProductSuccessfully() {
        // Arrange
        Long productId = 1L;
        Product productToUpdate = new Product("Apple Updated", new BigDecimal("1.75"), "image_url_new", 15, "An updated apple");
        Product updatedProduct = new Product(productId, "Apple Updated", new BigDecimal("1.75"), null, "image_url_new", 15, "An updated apple");
        
        when(productPort.update(productToUpdate, productId)).thenReturn(updatedProduct);

        // Act
        Product result = updateProductUseCase.execute(productToUpdate, productId);

        // Assert
        assertEquals(updatedProduct, result);
        verify(productPort, times(1)).update(productToUpdate, productId);
    }
}
