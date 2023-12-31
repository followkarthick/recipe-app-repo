package com.mydemo.recipe.controllers;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.mydemo.recipe.api.request.CreateRecipeRequest;
import com.mydemo.recipe.api.request.RecipeSearchRequest;
import com.mydemo.recipe.api.request.UpdateRecipeRequest;
import com.mydemo.recipe.api.response.CreateEntityResponse;
import com.mydemo.recipe.api.response.RecipeResponse;
import com.mydemo.recipe.models.Recipe;
import com.mydemo.recipe.services.RecipeService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "RecipeController", tags = "Recipe Controller", description = "create, update, delete, list recipes")
@RestController
@RequestMapping(value = "api/v1/recipe")
public class RecipeController {
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ApiOperation(value = "List all recipes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
    })
    @RequestMapping(method = RequestMethod.GET, path = "/page/{page}/size/{size}")
    public List<RecipeResponse> getRecipeList(@PathVariable(name = "page") int page,
                                              @PathVariable(name = "size") int size) {
        logger.info("Getting the recipes");
        List<Recipe> list = recipeService.getRecipeList(page, size);

        return list.stream()
                .map(RecipeResponse::new)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "List one recipe by its ID", response = RecipeResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 404, message = "Recipe not found by the given ID")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeResponse getRecipe(@ApiParam(value = "Recipe ID", required = true) @PathVariable(name = "id") Integer id) {
        logger.info("Getting the recipe by its id. Id: {}", id);
        Recipe recipe = recipeService.getRecipeById(id);
        return new RecipeResponse(recipe);
    }

    @ApiOperation(value = "Create a recipe")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Recipe created"),
            @ApiResponse(code = 400, message = "Bad input")
    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEntityResponse createRecipe(
            @ApiParam(value = "Properties of the recipe", required = true) @Valid @RequestBody CreateRecipeRequest request) {
        logger.info("Creating the recipe with properties");
        Integer id = recipeService.createRecipe(request);
        return new CreateEntityResponse(id);
    }

    @ApiOperation(value = "Update the recipe")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ingredient created"),
            @ApiResponse(code = 400, message = "Bad input")
    })
    @RequestMapping(method = RequestMethod.PATCH)
    public void updateRecipe(
            @ApiParam(value = "Properties of the recipe", required = true) @Valid @RequestBody UpdateRecipeRequest updateRecipeRequest) {
        logger.info("Updating the recipe by given properties");
        recipeService.updateRecipe(updateRecipeRequest);
    }

    @ApiOperation(value = "Delete the recipe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation"),
            @ApiResponse(code = 400, message = "Invalid input"),
            @ApiResponse(code = 404, message = "Recipe not found by the given ID")
    })
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteRecipe(
            @ApiParam(value = "Recipe ID", required = true) @NotNull(message = "{id.notNull}") @RequestParam(name = "id") Integer id) {
        logger.info("Deleting the recipe by its id. Id: {}", id);
        recipeService.deleteRecipe(id);
    }

    @ApiOperation(value = "Search recipes by given parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 404, message = "Different error messages related to criteria and recipe")

    })
    @RequestMapping(method = RequestMethod.POST, path = "/search")
    public List<RecipeResponse> searchRecipe(@RequestParam(name = "page", defaultValue = "0") int page,
                                             @RequestParam(name = "size", defaultValue = "10") int size,
                                             @ApiParam(value = "Properties of the the search")
                                             @RequestBody @Valid RecipeSearchRequest recipeSearchRequest) {
        logger.info("Searching the recipe by given criteria");
        return recipeService.findBySearchCriteria(recipeSearchRequest, page, size);
    }
}
