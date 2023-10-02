package com.mydemo.recipe.unit.validator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mydemo.recipe.api.request.CreateIngredientRequest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class EnumValidatorConstraintTest {
    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

    @Test
    public void whenNotBlankName_thenNoConstraintViolations() {
        CreateIngredientRequest request = new CreateIngredientRequest("pasta");

        Set<ConstraintViolation<CreateIngredientRequest>> violations = validator.validate(request);

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenBlankName_thenOneConstraintViolation() {
        CreateIngredientRequest request = new CreateIngredientRequest(null);

        Set<ConstraintViolation<CreateIngredientRequest>> violations = validator.validate(request);
        String collect = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));

        assertEquals(collect, "{ingredient.notBlank}");
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenEmptyName_thenOneConstraintViolation() {
        CreateIngredientRequest request = new CreateIngredientRequest(null);

        Set<ConstraintViolation<CreateIngredientRequest>> violations = validator.validate(request);
        String collect = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));

        assertEquals(collect, "{ingredient.notBlank}");
        assertThat(violations.size()).isEqualTo(1);
    }


}
