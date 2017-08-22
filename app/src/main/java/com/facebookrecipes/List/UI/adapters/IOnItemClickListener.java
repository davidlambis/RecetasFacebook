package com.facebookrecipes.List.UI.adapters;

import com.facebookrecipes.Recipe;

public interface IOnItemClickListener {
    void onFavClick(Recipe recipe);

    void onItemClick(Recipe recipe);

    void onDeleteClick(Recipe recipe);
}
