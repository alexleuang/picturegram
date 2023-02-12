package com.nashss.se.picturegram.Activity.Request;

public class GetCommentRequest {
    private final String imageUrl;

    private GetCommentRequest(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "GetCommentRequest{" +
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

        public GetCommentRequest build() {
            return new GetCommentRequest(imageUrl);
        }
    }
}
