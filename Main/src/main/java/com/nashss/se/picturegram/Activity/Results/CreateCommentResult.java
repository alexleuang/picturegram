package com.nashss.se.picturegram.Activity.Results;

public class CreateCommentResult {
    private final CommentModel commentModel;

    private CreateCommentResult(CommentModel commentModel) {
        this.commentModel = commentModel;
    }

    public CommentModel getCommentModel() {
        return commentModel;
    }

    @Override
    public String toString() {
        return "CreateCommentResult{" +
                "commentModel=" + commentModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CommentModel commentModel;

        public builder withCommentModel(CommentModel commentModel) {
            this.commentModel = commentModel;
            return this;
        }

        public CreateCommentResult build() {
            return new CreateCommentResult(commentModel);
        }
    }
}
