package com.nashss.se.picturegram.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.picturegram.Exceptions.ImageNotFoundException;
import com.nashss.se.picturegram.dynamodb.models.Image;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ImageDao {
    private final DynamoDBMapper dynamoDBMapper;


    @Inject
    public ImageDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDBMapper = dynamoDbMapper;
    }

    public Image getOwnerEmail(String ownerEmail) {
        Image image = this.dynamoDBMapper.load(Image.class, ownerEmail);

        if (image == null) {
            throw new ImageNotFoundException("Could not find this image for this email:" + ownerEmail);
        }
        return image;
    }

    public void saveImage(Image image) {
        this.dynamoDBMapper.save(image);
    }

    public void deleteImage(Image image) {
        image.setImageUrl(image.getImageUrl());
        this.dynamoDBMapper.delete(image);
    }
}
