package com.facebookrecipes;

import android.app.Application;
import android.content.Intent;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebookrecipes.Libs.DI.LibsModule;
import com.facebookrecipes.List.DI.DaggerRecipeListComponent;
import com.facebookrecipes.List.DI.RecipeListComponent;
import com.facebookrecipes.List.DI.RecipeListModule;
import com.facebookrecipes.List.UI.RecipeListActivity;
import com.facebookrecipes.List.UI.RecipeListView;
import com.facebookrecipes.List.UI.adapters.IOnItemClickListener;
import com.facebookrecipes.Login.LoginActivity;
import com.facebookrecipes.Main.DI.DaggerRecipeMainComponent;
import com.facebookrecipes.Main.DI.RecipeMainComponent;
import com.facebookrecipes.Main.DI.RecipeMainModule;
import com.facebookrecipes.Main.UI.RecipeMainActivity;
import com.facebookrecipes.Main.UI.RecipeMainView;
import com.raizlabs.android.dbflow.config.FlowManager;

public class FacebookRecipesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view) {
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }

    public RecipeListComponent getRecipeListComponent(RecipeListActivity activity, RecipeListView view, IOnItemClickListener clickListener) {
        return DaggerRecipeListComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeListModule(new RecipeListModule(view, clickListener))
                .build();
    }
}
