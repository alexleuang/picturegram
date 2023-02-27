package com.nashss.se.picturegram.activity;

import com.nashss.se.picturegram.Exceptions.CommentNotFoundException;
import com.nashss.se.picturegram.Models.CommentModel;
import com.nashss.se.picturegram.activity.Request.DeleteCommentRequest;
import com.nashss.se.picturegram.activity.Results.DeleteCommentResult;
import com.nashss.se.picturegram.converters.ModelConverter;
import com.nashss.se.picturegram.dynamodb.CommentDao;
import com.nashss.se.picturegram.dynamodb.models.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteCommentActivity {
    private final Logger log = LogManager.getLogger();
    private final CommentDao commentDao;

    @Inject
    public DeleteCommentActivity(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public DeleteCommentResult handleRequest(DeleteCommentRequest deleteCommentRequest) {
        log.info("Received DeletedCommentRequest {}", deleteCommentRequest);

        if (deleteCommentRequest.getImageUrl() == null) {
            throw new CommentNotFoundException("Comment not found.");
        }

        if (commentDao.getImageUrl(deleteCommentRequest.getImageUrl()) == null) {
            throw new CommentNotFoundException("Comment not found");
        }

        Comment commentDeleted = commentDao.getImageUrl(deleteCommentRequest.getImageUrl());

        commentDao.deleteComment(commentDeleted);

        CommentModel commentModel = new ModelConverter().toCommentModel(commentDeleted);
        return DeleteCommentResult.builder()
                .withComment(commentModel)
                .build();
    }
}
