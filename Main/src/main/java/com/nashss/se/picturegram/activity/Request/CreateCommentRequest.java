package com.nashss.se.picturegram.activity.Request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

@JsonDeserialize(builder = CreateCommentRequest.Builder.class)
public class CreateCommentRequest {
        private final String imageUrl;
        private final String commenterEmail;
        private final String commenterName;
        private final String comment;
        LocalDateTime dateTime;


    public CreateCommentRequest(String imageUrl, String commenterEmail, String commenterName, String comment, LocalDateTime dateTime) {
        this.imageUrl = imageUrl;
        this.commenterEmail = commenterEmail;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCommenterEmail() {
        return commenterEmail;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "CreateCommentRequest{" +
                "imageUrl='" + imageUrl + '\'' +
                ", commenterEmail='" + commenterEmail + '\'' +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    //CHECKSTYLE::OFF:Builder
    public static Builder Builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String imageUrl;
        private String commenterEmail;
        private String commenterName;
        private String comment;
        LocalDateTime dateTime;

        public Builder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder withCommenterEmail(String commenterEmail) {
            this.commenterEmail = commenterEmail;
            return this;
        }

        public Builder withCommenterName(String commenterName) {
            this.commenterName = commenterName;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder withDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CreateCommentRequest build() {
            return new CreateCommentRequest(
                    imageUrl,
                    commenterEmail,
                    commenterName,
                    comment,
                    dateTime);
        }
    }
}
