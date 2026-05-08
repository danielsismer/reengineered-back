package com.weg.reenginered.application.usecase.category;

import com.weg.reenginered.domain.entity.Category;
import com.weg.reenginered.domain.port.CategoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveCategoryUseCaseTest {

    @Mock
    private CategoryPort categoryPort;

    @InjectMocks
    private SaveCategoryUseCase saveCategoryUseCase;

    @Test
    void execute_ShouldSaveCategorySuccessfully() {
        // Arrange
        Category category = new Category("Fruits");
        Category savedCategory = new Category(1L, "Fruits");
        when(categoryPort.save(category)).thenReturn(savedCategory);

        // Act
        Category result = saveCategoryUseCase.execute(category);

        // Assert
        assertEquals(savedCategory, result);
        verify(categoryPort, times(1)).save(category);
    }
}
