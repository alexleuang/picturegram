package com.nashss.se.picturegram.Models;

import java.time.LocalDateTime;
import java.util.Objects;

public class ImageModel {

    private final String imageId;
    private final String imageUrl;
    private final String caption;
    LocalDateTime dateTime;

    public ImageModel(String imageId, String imageUrl, String caption, LocalDateTime dateTime) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.dateTime = dateTime;
    }

    public String getImageId() {
        return imageId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageModel that = (ImageModel) o;
        return Objects.equals(imageId, that.imageId) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(caption, that.caption) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, imageUrl, caption, dateTime);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String imageId;
        private String imageUrl;
        private String caption;
        LocalDateTime dateTime;

        public Builder withImageId(String imageId) {
            this.imageId = imageId;
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
            return new ImageModel(imageId, imageUrl, caption, dateTime);
        }
    }
}
