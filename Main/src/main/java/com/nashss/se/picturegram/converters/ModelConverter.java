package com.nashss.se.picturegram.converters;

import com.nashss.se.picturegram.Models.CommentModel;
import com.nashss.se.picturegram.Models.ImageModel;
import com.nashss.se.picturegram.dynamodb.models.Comment;
import com.nashss.se.picturegram.dynamodb.models.Image;

public class ModelConverter {

    public ImageModel toImageModel(Image image) {
        return ImageModel.builder()
                .withOwnerEmail(image.getOwnerEmail())
                .withOwnerName(image.getOwnerName())
                .withImageUrl(image.getImageUrl())
                .withCaption(image.getCaption())
                .withLocalDateTime(image.getDateTime())
                .build();
    }

    public CommentModel toCommentModel(Comment comment) {
        return CommentModel.builder()
                .withImageUrl(comment.getImageUrl())
                .withCommenterEmail(comment.getCommenterEmail())
                .withCommenterName(comment.getCommenterName())
                .withComment(comment.getComment())
                .withLocalDateTime(comment.getDateTime())
                .build();

    }
}
