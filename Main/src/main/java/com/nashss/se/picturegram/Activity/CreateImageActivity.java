package com.nashss.se.picturegram.Activity;

import com.nashss.se.picturegram.Activity.Request.CreateImageRequest;
import com.nashss.se.picturegram.Activity.Results.CreateImageResult;
import com.nashss.se.picturegram.dynamodb.ImageDao;
import com.nashss.se.picturegram.dynamodb.models.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class CreateImageActivity {

    private final Logger Log = LogManager.getLogger();
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

        return CreateImageResult.builder()
                .withImage(image)
                .build();

    }
}
