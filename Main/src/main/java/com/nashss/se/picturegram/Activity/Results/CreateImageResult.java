package com.nashss.se.picturegram.Activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;

public class CreateImageResult {
    private final ImageModel imageModel;

    private CreateImageResult(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    @Override
    public String toString() {
        return "CreateImageResult{" +
                "imageModel=" + imageModel +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ImageModel imageModel;

        public Builder withImageModel(ImageModel imageModel) {
            this.imageModel = imageModel;
            return this;
        }

        public CreateImageResult build() {
            return new CreateImageResult(imageModel);
        }
    }
}
