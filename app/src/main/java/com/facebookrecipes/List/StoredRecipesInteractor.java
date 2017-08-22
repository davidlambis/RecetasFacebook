package com.facebookrecipes.List;

import com.facebookrecipes.Recipe;

public interface StoredRecipesInteractor {

    void executeUpdate(Recipe recipe);

    void executeDelete(Recipe recipe);
}
