package com.nashss.se.picturegram.Activity.Request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

@JsonDeserialize(builder = CreateImageRequest.Builder.class)
public class CreateImageRequest {
    private String ownerEmail;
    private String ownerName;
    private String imageUrl;
    private String captions;
    LocalDateTime dateTime;


    public CreateImageRequest(String ownerEmail, String ownerName, String imageUrl, String captions, LocalDateTime dateTime) {
        this.ownerEmail = ownerEmail;
        this.ownerName = ownerName;
        this.imageUrl = imageUrl;
        this.captions = captions;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }
    public String getOwnerName() { return ownerName; }
    public String getImageUrl() { return imageUrl;}
    public String getCaptions() {
        return captions;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "CreateImageRequest{" +
                "ownerEmail='" + ownerEmail + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", captions='" + captions + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String ownerEmail;
        private String ownerName;
        private String imageUrl;
        private String captions;
        LocalDateTime dateTime;

        public Builder withOwnerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }

        public Builder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder withCaptions(String captions) {
            this.captions = captions;
            return this;
        }

        public Builder withDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CreateImageRequest build() {
            return new CreateImageRequest(
                    ownerEmail,
                    ownerName,
                    imageUrl,
                    captions,
                    dateTime);
        }
    }
}
