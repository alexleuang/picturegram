package com.nashss.se.picturegram.Models;

import java.time.LocalDateTime;
import java.util.Objects;

public class ImageModel {

    private final String ownerEmail;
    private final String ownerName;
    private final String imageUrl;
    private final String caption;
    LocalDateTime dateTime;

    public ImageModel(String ownerEmail, String ownerName, String imageUrl, String caption, LocalDateTime dateTime) {
        this.ownerEmail = ownerEmail;
        this.ownerName = ownerName;
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.dateTime = dateTime;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerName() { return ownerName; }
    public String getImageUrl() {
        return imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageModel that = (ImageModel) o;
        return Objects.equals(ownerEmail, that.ownerEmail) &&
                Objects.equals(ownerName, that.ownerName) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(caption, that.caption) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerEmail, ownerName, imageUrl, caption, dateTime);
    }

    public static class Builder {
        private String ownerEmail;
        private String ownerName;
        private String imageUrl;
        private String caption;
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

        public Builder withCaption(String caption) {
            this.caption = caption;
            return this;
        }

        public Builder withLocalDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public ImageModel build() {
            return new ImageModel(ownerEmail, ownerName, imageUrl, caption, dateTime);
        }
    }
}
