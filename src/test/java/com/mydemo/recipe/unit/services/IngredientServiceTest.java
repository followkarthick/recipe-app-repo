package com.mydemo.recipe.unit.services;

import com.mydemo.recipe.api.request.CreateIngredientRequest;
import com.mydemo.recipe.config.MessageProvider;
import com.mydemo.recipe.exceptions.NotFoundException;
import com.mydemo.recipe.models.Ingredient;
import com.mydemo.recipe.repositories.IngredientRepository;
import com.mydemo.recipe.services.IngredientService;
import com.mydemo.recipe.utils.builder.IngredientTestDataBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTest {
    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private MessageProvider messageProvider;

    @InjectMocks
    private IngredientService ingredientService;

    @Test
    public void test_createIngredient_successfully() {
        CreateIngredientRequest request = IngredientTestDataBuilder.createIngredientRequest();
        Ingredient response = IngredientTestDataBuilder.createIngredient();
        response.setId(5);

        when(ingredientRepository.save(any(Ingredient.class))).thenReturn(response);
        Integer id = ingredientService.create(request);
        assertThat(id).isSameAs(response.getId());
    }


    @Test
    public void test_deleteIngredient_successfully() {
        when(ingredientRepository.existsById(anyInt())).thenReturn(true);
        doNothing().when(ingredientRepository).deleteById(anyInt());

        ingredientService.delete(5);
    }

    @Test(expected = NotFoundException.class)
    public void test_deleteIngredient_notFound() {
        when(ingredientRepository.existsById(anyInt())).thenReturn(false);
        ingredientService.delete(1);
    }
}