package com.facebookrecipes.Main.UI;

import com.facebookrecipes.Recipe;

public interface RecipeMainView {

    void showProgress();

    void hideProgress();

    void showUIElements();

    void hideUIElements();

    void saveAnimation();

    void dismissAnimation();

    void onRecipeSaved();

    void setRecipe(Recipe recipe);

    void onGetRecipeError(String error);

}
