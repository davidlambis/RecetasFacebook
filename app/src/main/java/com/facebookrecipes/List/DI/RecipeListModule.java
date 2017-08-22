package com.facebookrecipes.List.DI;

import com.facebookrecipes.Libs.Base.EventBus;
import com.facebookrecipes.Libs.Base.ImageLoader;
import com.facebookrecipes.List.RecipeListInteractor;
import com.facebookrecipes.List.RecipeListInteractorImpl;
import com.facebookrecipes.List.RecipeListPresenter;
import com.facebookrecipes.List.RecipeListPresenterImpl;
import com.facebookrecipes.List.RecipeListRepository;
import com.facebookrecipes.List.RecipeListRepositoryImpl;
import com.facebookrecipes.List.StoredRecipesInteractor;
import com.facebookrecipes.List.StoredRecipesInteractorImpl;
import com.facebookrecipes.List.UI.RecipeListView;
import com.facebookrecipes.List.UI.adapters.IOnItemClickListener;
import com.facebookrecipes.List.UI.adapters.RecipeListAdapter;
import com.facebookrecipes.Recipe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RecipeListModule {
    RecipeListView view;
    IOnItemClickListener clickListener;

    public RecipeListModule(RecipeListView view, IOnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    RecipeListView providesRecipeListView() {
        return this.view;
    }

    @Provides
    @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor,
                                                    StoredRecipesInteractor storedInteractor) {
        return new RecipeListPresenterImpl(eventBus, view, listInteractor, storedInteractor);
    }

    @Provides
    @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository) {
        return new RecipeListInteractorImpl(repository);
    }

    @Provides
    @Singleton
    StoredRecipesInteractor providesStoredRecipesInteractor(RecipeListRepository repository) {
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus) {
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides
    @Singleton
    RecipeListAdapter providesRecipeListAdapter(List<Recipe> recipeList, ImageLoader imageLoader,
                                                IOnItemClickListener onItemClickListener) {
        return new RecipeListAdapter(recipeList, imageLoader, onItemClickListener);
    }

    @Provides
    @Singleton
    IOnItemClickListener providesOnItemClickListener() {
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Recipe> providesEmptyList() {
        return new ArrayList<Recipe>();
    }
}
