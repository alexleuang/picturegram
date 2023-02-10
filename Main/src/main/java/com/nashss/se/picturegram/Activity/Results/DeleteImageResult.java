package com.nashss.se.picturegram.Activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;

public class DeleteImageResult {

    private final ImageModel imageModel;

    public DeleteImageResult(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    @Override
    public String toString() {
        return "DeleteImageResult{" +
                "imageModel=" + imageModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ImageModel imageModel;

        public Builder withImageModel(ImageModel imageModel) {
            this.imageModel = imageModel;
            return this;
        }

        public DeleteImageResult build() {
             return new DeleteImageResult(imageModel);
        }
    }
}
