package com.mydemo.recipe.api.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.mydemo.recipe.config.ValidationConfig;

public class CreateIngredientRequest {
    @NotBlank(message = "{ingredient.notBlank}")
    @Size(max = ValidationConfig.MAX_LENGTH_NAME, message = "{ingredient.size}")
    @ApiModelProperty(notes = "The name of the ingredient", example = "Potato")
    private String name;

    public CreateIngredientRequest() {
    }

    public CreateIngredientRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
