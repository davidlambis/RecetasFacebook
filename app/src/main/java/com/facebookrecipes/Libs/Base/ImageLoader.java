package com.facebookrecipes.Libs.Base;

import android.widget.ImageView;

public interface ImageLoader {

    void load(ImageView imageView, String URL);

    void setOnFinishedImageLoadingListener(Object listener);
}
