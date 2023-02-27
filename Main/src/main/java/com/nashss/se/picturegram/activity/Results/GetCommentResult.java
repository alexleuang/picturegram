package com.nashss.se.picturegram.activity.Results;

import com.nashss.se.picturegram.Models.CommentModel;

public class GetCommentResult {
    private final CommentModel comment;

    private GetCommentResult(CommentModel comment) {
        this.comment = comment;
    }

    public CommentModel getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "GetCommentResult{" +
                "comment=" + comment +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CommentModel comment;

        public Builder withImageUrl(CommentModel comment) {
            this.comment = comment;
            return this;
        }

        public GetCommentResult build() {
            return new GetCommentResult(comment);
        }
    }
}
