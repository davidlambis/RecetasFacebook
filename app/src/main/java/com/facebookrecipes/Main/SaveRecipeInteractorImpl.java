package com.facebookrecipes.Main;

import com.facebookrecipes.Recipe;

public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {

    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
