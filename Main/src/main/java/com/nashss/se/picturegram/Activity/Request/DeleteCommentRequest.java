package com.nashss.se.picturegram.Activity.Request;

public class DeleteCommentRequest {
    private String imageUrl;

    private DeleteCommentRequest(String imageUrl) {
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
        return "DeleteCommentRequest{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String imageUrl;

        public DeleteCommentRequest.Builder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public DeleteCommentRequest build() {
            return new DeleteCommentRequest(imageUrl);
        }
    }
}
