package com.nashss.se.picturegram.Activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;

public class DeleteImageResult {

    private final ImageModel image;

    public DeleteImageResult(ImageModel image) {
        this.image = image;
    }

    public ImageModel getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "DeleteImageResult{" +
                "image=" + image +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ImageModel image;

        public Builder withImage(ImageModel image) {
            this.image = image;
            return this;
        }

        public DeleteImageResult build() {
             return new DeleteImageResult(image);
        }
    }
}
