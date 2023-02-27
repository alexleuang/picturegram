package com.nashss.se.picturegram.Models;

import java.time.LocalDateTime;
import java.util.Objects;

public class CommentModel {

    private final String imageUrl;
    private final String commenterEmail;
    private final String commenterName;
    private final String comment;
    LocalDateTime datetime;

    public CommentModel(String imageUrl, String commenterEmail, String commenterName, String comment, LocalDateTime datetime) {
        this.imageUrl = imageUrl;
        this.commenterEmail = comment;
        this.commenterName = comment;
        this.comment = comment;
        this.datetime = datetime;
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

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {return new Builder();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentModel that = (CommentModel) o;
        return Objects.equals(imageUrl, that.imageUrl) && Objects.equals(commenterEmail, that.commenterEmail) && Objects.equals(commenterName, that.commenterName) && Objects.equals(comment, that.comment) && Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl, commenterEmail, commenterName, comment, datetime);
    }

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

        public Builder withLocalDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CommentModel build() {
            return new CommentModel(imageUrl, commenterEmail, commenterName, comment, dateTime);
        }
    }
}
