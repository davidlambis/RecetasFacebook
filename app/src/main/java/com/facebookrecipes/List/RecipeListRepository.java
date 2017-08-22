package com.facebookrecipes.List;

import com.facebookrecipes.Recipe;

public interface RecipeListRepository {
    void getSavedRecipes();

    void updateRecipe(Recipe recipe);

    void removeRecipe(Recipe recipe);
}
