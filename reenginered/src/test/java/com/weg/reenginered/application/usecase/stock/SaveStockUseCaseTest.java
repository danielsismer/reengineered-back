package com.weg.reenginered.application.usecase.stock;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.entity.Product;
import com.weg.reenginered.domain.entity.Stock;
import com.weg.reenginered.domain.port.StockPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveStockUseCaseTest {

    @Mock
    private StockPort stockPort;

    @InjectMocks
    private SaveStockUseCase saveStockUseCase;

    @Test
    void execute_ShouldSaveStockSuccessfully() {
        // Arrange
        Product product = new Product(1L, "Apple", new BigDecimal("1.50"), null, "url", 10, "desc");
        Local local = new Local(1L, "Warehouse A", 1);
        LocalDateTime arrivalDate = LocalDateTime.now();
        Stock stock = new Stock(product, arrivalDate, local);
        Stock savedStock = new Stock(1L, product, arrivalDate, local);
        
        when(stockPort.save(stock)).thenReturn(savedStock);

        // Act
        Stock result = saveStockUseCase.execute(stock);

        // Assert
        assertEquals(savedStock, result);
        verify(stockPort, times(1)).save(stock);
    }
}
