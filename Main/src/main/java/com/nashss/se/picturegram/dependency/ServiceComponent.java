package com.nashss.se.picturegram.dependency;

import com.nashss.se.picturegram.Activity.CreateImageActivity;
import com.nashss.se.picturegram.Activity.DeleteImageActivity;
import com.nashss.se.picturegram.Activity.GetImageActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class, MetricModule.class})
public interface ServiceComponent {
    CreateImageActivity provideCreateImageActivity();
    GetImageActivity provideGetImageActivity();
    DeleteImageActivity provideDeleteImage();
}
