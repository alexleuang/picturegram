package com.nashss.se.picturegram.converters;

import com.nashss.se.picturegram.Models.ImageModel;
import com.nashss.se.picturegram.dynamodb.models.Image;

public class ModelConverter {

    public ImageModel toImageModel(Image image) {
        return ImageModel.builder()
                .withOwnerEmail(image.getOwnerEmail())
                .withOwnerName(image.getOwnerName())
                .withImageUrl(image.getImageUrl())
                .withCaption(image.getCaption())
                .withLocalDateTime(image.getDateTime())
                .build();
    }
}
