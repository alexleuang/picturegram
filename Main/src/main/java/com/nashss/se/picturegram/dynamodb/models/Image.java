package com.nashss.se.picturegram.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.LocalDateTime;
import java.util.Objects;

@DynamoDBTable(tableName = "Images")
public class Image {
    private String ownerEmail;
    private String ownerName;
    private String imageUrl;
    private String caption;
    LocalDateTime dateTime;

    @DynamoDBHashKey(attributeName = "ownerEmail")
    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @DynamoDBAttribute(attributeName = "ownerName")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @DynamoDBAttribute(attributeName = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @DynamoDBAttribute(attributeName = "caption")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @DynamoDBAttribute(attributeName = "dateTime")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(ownerEmail, image.ownerEmail) &&
                Objects.equals(ownerName, image.ownerName) &&
                Objects.equals(imageUrl, image.imageUrl) &&
                Objects.equals(caption, image.caption) &&
                Objects.equals(dateTime, image.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerEmail, ownerName, imageUrl, caption, dateTime);
    }
}
