package com.nashss.se.picturegram.activity;

import com.nashss.se.picturegram.Models.CommentModel;
import com.nashss.se.picturegram.activity.Request.GetCommentRequest;
import com.nashss.se.picturegram.activity.Results.GetCommentResult;
import com.nashss.se.picturegram.converters.ModelConverter;
import com.nashss.se.picturegram.dynamodb.CommentDao;
import com.nashss.se.picturegram.dynamodb.models.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


    public class GetCommentActivity {
        private final Logger log = LogManager.getLogger();
        private final CommentDao commentDao;

        @Inject
        public GetCommentActivity(CommentDao commentDao) {
            this.commentDao = commentDao;
        }


        public GetCommentResult handleRequest(final GetCommentRequest getCommentRequest) {
            log.info("Received GetCommentRequest {}", getCommentRequest);
            String requestedImageUrl = getCommentRequest.getImageUrl();
            Comment comment = commentDao.getImageUrl(requestedImageUrl);
            CommentModel commentModel = new ModelConverter().toCommentModel(comment);

            return GetCommentResult.builder()
                    .withImageUrl(commentModel)
                    .build();
        }
}
