package com.weg.reenginered.application.usecase.product;

import com.weg.reenginered.domain.dto.filter.ProductFilter;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.port.ProductPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindProductUseCaseTest {

    @Mock
    private ProductPort productPort;

    @InjectMocks
    private FindProductUseCase findProductUseCase;

    @Test
    void execute_ShouldReturnProductList() {
        // Arrange
        ProductFilter filter = new ProductFilter("Apple", null, null);
        Product product = new Product(1L, "Apple", new BigDecimal("1.50"), null, "image_url", 10, "A red apple");
        List<Product> products = List.of(product);
        when(productPort.findAll(filter)).thenReturn(products);

        // Act
        List<Product> result = findProductUseCase.execute(filter);

        // Assert
        assertEquals(products, result);
        verify(productPort, times(1)).findAll(filter);
    }
}
