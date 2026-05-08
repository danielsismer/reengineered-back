package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.port.ProductPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveProductUseCaseTest {

    @Mock
    private ProductPort productPort;

    @InjectMocks
    private SaveProductUseCase saveProductUseCase;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Apple", new BigDecimal("1.50"), "image_url", 10, "A red apple");
    }

    @Test
    void execute_ShouldSaveProductSuccessfully() {
        // Arrange
        Product savedProduct = new Product(1L, "Apple", new BigDecimal("1.50"), null, "image_url", 10, "A red apple");
        when(productPort.save(any(Product.class))).thenReturn(savedProduct);

        // Act
        Product result = saveProductUseCase.execute(product);

        // Assert
        assertEquals(savedProduct, result);
        verify(productPort, times(1)).save(product);
    }
}
