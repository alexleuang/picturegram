package com.nashss.se.picturegram.activity;

import com.nashss.se.picturegram.Exceptions.ImageNotFoundException;
import com.nashss.se.picturegram.activity.Request.GetImageRequest;
import com.nashss.se.picturegram.activity.Results.GetImageResult;
import com.nashss.se.picturegram.Models.ImageModel;
import com.nashss.se.picturegram.converters.ModelConverter;
import com.nashss.se.picturegram.dynamodb.ImageDao;
import com.nashss.se.picturegram.dynamodb.models.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetImageActivity {
    private final Logger log = LogManager.getLogger();

    private final ImageDao imageDao;


    @Inject
    public GetImageActivity(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public GetImageResult handleRequest(final GetImageRequest getImageRequest) {
        log.info("Received GetImageRequest {}", getImageRequest);
        String requestedOwnerEmail = getImageRequest.getOwnerEmail();
        Image image = imageDao.getOwnerEmail(requestedOwnerEmail);
//        ImageModel imageModel = new ModelConverter().toImageModel(image);

        if (image ==null) {
            throw new ImageNotFoundException("Image not found" + requestedOwnerEmail);
        }
        return GetImageResult.builder()
                .withOwnerEmail(image)
                .build();
    }
}
