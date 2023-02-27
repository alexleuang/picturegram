package com.nashss.se.picturegram.activity;

import com.nashss.se.picturegram.Models.CommentModel;
import com.nashss.se.picturegram.activity.Request.CreateCommentRequest;
import com.nashss.se.picturegram.activity.Results.CreateCommentResult;
import com.nashss.se.picturegram.converters.ModelConverter;
import com.nashss.se.picturegram.dynamodb.CommentDao;
import com.nashss.se.picturegram.dynamodb.models.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class CreateCommentActivity {
    private final Logger log = LogManager.getLogger();
    private final CommentDao commentDao;

    @Inject
    public CreateCommentActivity(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public CreateCommentResult handleRequest(CreateCommentRequest createCommentRequest) {
        log.info("Received CreateCommentRequest {}", createCommentRequest);


        Comment newComment = new Comment();
        newComment.setImageUrl(createCommentRequest.getImageUrl());
        newComment.setCommenterEmail(createCommentRequest.getCommenterEmail());
        newComment.setCommenterName(createCommentRequest.getCommenterName());
        newComment.setComment(createCommentRequest.getComment());
        newComment.setDateTime(LocalDateTime.now());

        commentDao.saveComment(newComment);

        CommentModel commentModel = new ModelConverter().toCommentModel(newComment);
        return CreateCommentResult.builder()
                .withComment(commentModel)
                .build();

    }
}
