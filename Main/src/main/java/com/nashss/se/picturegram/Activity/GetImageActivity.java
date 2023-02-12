package com.nashss.se.picturegram.Activity;

import com.nashss.se.picturegram.Activity.Request.GetImageRequest;
import com.nashss.se.picturegram.Activity.Results.GetImageResult;
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
        String requestedImageUrl = getImageRequest.getImageUrl();
        Image image = imageDao.getImage(requestedImageUrl);
        ImageModel imageModel = new ModelConverter().toImageModel(image);

        return GetImageResult.builder()
                .withImage(imageModel)
                .build();
    }
}
