package com.nashss.se.picturegram.Activity.Request;

public class DeleteImageRequest {

    private String imageUrl;

    private DeleteImageRequest(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "DeleteImageRequest{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String imageUrl;

        public Builder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public DeleteImageRequest build() {
            return new DeleteImageRequest(imageUrl);
        }
    }
}
