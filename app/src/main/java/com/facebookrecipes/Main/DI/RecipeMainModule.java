package com.facebookrecipes.Main.DI;

import com.facebookrecipes.API.RecipeClient;
import com.facebookrecipes.API.RecipeService;
import com.facebookrecipes.Libs.Base.EventBus;
import com.facebookrecipes.Main.GetNextRecipeInteractor;
import com.facebookrecipes.Main.GetNextRecipeInteractorImpl;
import com.facebookrecipes.Main.RecipeMainPresenter;
import com.facebookrecipes.Main.RecipeMainPresenterImpl;
import com.facebookrecipes.Main.RecipeMainRepository;
import com.facebookrecipes.Main.RecipeMainRepositoryImpl;
import com.facebookrecipes.Main.SaveRecipeInteractor;
import com.facebookrecipes.Main.SaveRecipeInteractorImpl;
import com.facebookrecipes.Main.UI.RecipeMainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    RecipeMainView providesRecipeMainView() {
        return this.view;
    }

    @Provides
    @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextInteractor) {
        return new RecipeMainPresenterImpl(eventBus, view, saveInteractor, getNextInteractor);
    }

    @Provides
    @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository) {
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides
    @Singleton
    GetNextRecipeInteractor providesNextRecipeInteractor(RecipeMainRepository repository) {
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service) {
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides
    @Singleton
    RecipeService providesRecipeService() {
        return new RecipeClient().getRecipeService();
    }


}
