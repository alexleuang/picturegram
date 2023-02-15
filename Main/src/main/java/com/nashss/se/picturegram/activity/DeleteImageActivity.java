package com.nashss.se.picturegram.activity;

import com.nashss.se.picturegram.activity.Request.DeleteImageRequest;
import com.nashss.se.picturegram.activity.Results.DeleteImageResult;
import com.nashss.se.picturegram.Exceptions.ImageNotFoundException;
import com.nashss.se.picturegram.Models.ImageModel;
import com.nashss.se.picturegram.converters.ModelConverter;
import com.nashss.se.picturegram.dynamodb.ImageDao;
import com.nashss.se.picturegram.dynamodb.models.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteImageActivity {

    private final Logger log = LogManager.getLogger();
    private final ImageDao imageDao;

    @Inject
    public DeleteImageActivity(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public DeleteImageResult handleRequest(DeleteImageRequest deleteImageRequest) {
        log.info("Received DeletedImageRequest {}", deleteImageRequest);

        if (deleteImageRequest.getImageUrl() == null) {
            throw new ImageNotFoundException("Image not found.");
        }

        if (imageDao.getImage(deleteImageRequest.getImageUrl()) == null) {
            throw new ImageNotFoundException("Image not found");
        }

        Image imageDeleted = imageDao.getImage(deleteImageRequest.getImageUrl());

        imageDao.deleteImage(imageDeleted);

        ImageModel imageModel = new ModelConverter().toImageModel(imageDeleted);
        return DeleteImageResult.builder()
                .withImage(imageModel)
                .build();
    }
}
