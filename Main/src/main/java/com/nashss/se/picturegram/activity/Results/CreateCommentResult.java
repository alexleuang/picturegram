package com.nashss.se.picturegram.activity.Results;

import com.nashss.se.picturegram.Models.CommentModel;

public class CreateCommentResult {
    private final CommentModel comment;

    private CreateCommentResult(CommentModel comment) {
        this.comment = comment;
    }

    public CommentModel getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "CreateCommentResult{" +
                "comment=" + comment +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CommentModel comment;

        public Builder withComment(CommentModel comment) {
            this.comment = comment;
            return this;
        }

        public CreateCommentResult build() {
            return new CreateCommentResult(comment);
        }
    }
}
