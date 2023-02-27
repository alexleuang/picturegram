package com.nashss.se.picturegram.dependency;

import com.nashss.se.picturegram.activity.CreateImageActivity;
//import com.nashss.se.picturegram.activity.DeleteImageActivity;
import com.nashss.se.picturegram.activity.GetImageActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class, MetricModule.class})
public interface ServiceComponent {
    CreateImageActivity provideCreateImageActivity();
    GetImageActivity provideGetImageActivity();
//    DeleteImageActivity provideDeleteImage();
}
