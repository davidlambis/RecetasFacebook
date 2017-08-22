package com.facebookrecipes.List.DI;

import com.facebookrecipes.Libs.Base.ImageLoader;
import com.facebookrecipes.Libs.DI.LibsModule;
import com.facebookrecipes.List.RecipeListPresenter;
import com.facebookrecipes.List.UI.adapters.RecipeListAdapter;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {

    RecipeListAdapter getAdapter();

    RecipeListPresenter getPresenter();
}
