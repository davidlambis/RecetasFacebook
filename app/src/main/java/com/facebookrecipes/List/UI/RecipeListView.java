package com.facebookrecipes.List.UI;

import com.facebookrecipes.Recipe;

import java.util.List;

public interface RecipeListView {

    void setRecipes(List<Recipe> data);

    void recipeUpdated();

    void recipeDeleted(Recipe recipe);
}
