package com.nashss.se.picturegram.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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

    public Image getImage(String ownerEmail) {
        Image image = this.dynamoDBMapper.load(Image.class, ownerEmail);

        if (image == null) {
            throw new OwnerEmailNowFoundException("Could not find email:" + ownerEmail + "for this image.");
        }
        return image;
    }

    public void saveImage(Image image) {
        this.dynamoDBMapper.save(image);
    }
}
