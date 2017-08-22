package com.facebookrecipes.Main.DI;

import com.facebookrecipes.Libs.Base.ImageLoader;
import com.facebookrecipes.Libs.DI.LibsModule;
import com.facebookrecipes.Main.RecipeMainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {

    ImageLoader getImageLoader();

    RecipeMainPresenter getPresenter();
}
