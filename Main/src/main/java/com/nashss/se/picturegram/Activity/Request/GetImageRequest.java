package com.nashss.se.picturegram.Activity.Request;


public class GetImageRequest {
    private final String imageUrl;

    private GetImageRequest(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "GetImageRequest{" +
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
        public GetImageRequest build() {
            return new GetImageRequest(imageUrl);
        }
    }
}


