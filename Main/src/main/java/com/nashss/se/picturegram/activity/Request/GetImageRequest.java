package com.nashss.se.picturegram.activity.Request;


public class GetImageRequest {
    private final String ownerEmail;

    private GetImageRequest(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    @Override
    public String toString() {
        return "GetImageRequest{" +
                "ownerEmail='" + ownerEmail + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String ownerEmail;
        public Builder withOwnerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
            return this;
        }
        public GetImageRequest build() {
            return new GetImageRequest(ownerEmail);
        }
    }
}


