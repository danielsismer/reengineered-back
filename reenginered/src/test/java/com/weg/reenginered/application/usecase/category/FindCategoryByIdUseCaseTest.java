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
class FindCategoryByIdUseCaseTest {

    @Mock
    private CategoryPort categoryPort;

    @InjectMocks
    private FindCategoryByIdUseCase findCategoryByIdUseCase;

    @Test
    void execute_ShouldReturnCategory_WhenIdExists() {
        // Arrange
        Long categoryId = 1L;
        Category category = new Category(categoryId, "Fruits");
        when(categoryPort.listById(categoryId)).thenReturn(category);

        // Act
        Category result = findCategoryByIdUseCase.execute(categoryId);

        // Assert
        assertEquals(category, result);
        verify(categoryPort, times(1)).listById(categoryId);
    }
}
