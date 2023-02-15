package com.nashss.se.picturegram.activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;

public class CreateImageResult {
    private final ImageModel image;

    private CreateImageResult(ImageModel image) {
        this.image = image;
    }

    public ImageModel getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "CreateImageResult{" +
                "image=" + image +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ImageModel image;

        public Builder withImage(ImageModel image) {
            this.image = image;
            return this;
        }

        public CreateImageResult build() {
            return new CreateImageResult(image);
        }
    }
}
