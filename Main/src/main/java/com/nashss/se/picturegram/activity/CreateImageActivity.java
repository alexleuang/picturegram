package com.nashss.se.picturegram.activity;

import com.nashss.se.picturegram.activity.Request.CreateImageRequest;
import com.nashss.se.picturegram.activity.Results.CreateImageResult;
import com.nashss.se.picturegram.Models.ImageModel;
import com.nashss.se.picturegram.converters.ModelConverter;
import com.nashss.se.picturegram.dynamodb.ImageDao;
import com.nashss.se.picturegram.dynamodb.models.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class CreateImageActivity {

    private final Logger log = LogManager.getLogger();
    private final ImageDao imageDao;

    @Inject
    public CreateImageActivity(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public CreateImageResult handleRequest(CreateImageRequest createImageRequest) {
        log.info("Received CreateImageRequest {}", createImageRequest);


        Image image = new Image();
        image.setImageUrl(createImageRequest.getImageUrl());
        image.setOwnerEmail(createImageRequest.getOwnerEmail());
        image.setOwnerName(createImageRequest.getOwnerName());
        image.setCaption(createImageRequest.getCaption());
        image.setDateTime(LocalDateTime.now());

        imageDao.saveImage(image);

        ImageModel imageModel = new ModelConverter().toImageModel(image);
        return CreateImageResult.builder()
                .withImage(imageModel)
                .build();

    }
}
