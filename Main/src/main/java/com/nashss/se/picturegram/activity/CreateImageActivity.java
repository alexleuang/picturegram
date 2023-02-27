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


        Image newImage = new Image();
        newImage.setImageUrl(createImageRequest.getImageUrl());
        newImage.setOwnerEmail(createImageRequest.getOwnerEmail());
        newImage.setOwnerName(createImageRequest.getOwnerName());
        newImage.setCaption(createImageRequest.getCaption());
        newImage.setDateTime(LocalDateTime.now());

        imageDao.saveImage(newImage);

        ImageModel imageModel = new ModelConverter().toImageModel(newImage);
        return CreateImageResult.builder()
                .withImage(imageModel)
                .build();

    }
}
