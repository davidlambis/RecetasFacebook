package com.facebookrecipes.List;

import com.facebookrecipes.List.Events.RecipeListEvent;
import com.facebookrecipes.List.UI.RecipeListView;
import com.facebookrecipes.Recipe;

public interface RecipeListPresenter {

    void onCreate();

    void onDestroy();

    void getRecipes();

    void removeRecipe(Recipe recipe);

    void toggleFavorite(Recipe recipe);

    void onEventMainThread(RecipeListEvent event);

    RecipeListView getView();

}
