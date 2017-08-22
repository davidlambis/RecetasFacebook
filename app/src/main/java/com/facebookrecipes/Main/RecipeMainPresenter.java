package com.facebookrecipes.Main;

import com.facebookrecipes.Main.Events.RecipeMainEvent;
import com.facebookrecipes.Main.UI.RecipeMainView;
import com.facebookrecipes.Recipe;

public interface RecipeMainPresenter {
    void onCreate();

    void onDestroy();

    void dismissRecipe();

    void getNextRecipe();

    void saveRecipe(Recipe recipe);

    void onEventMainThread(RecipeMainEvent event);

    void imageReady();

    void imageError(String error);

    //Para TESTING
    RecipeMainView getView();
}
