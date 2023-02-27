package com.nashss.se.picturegram.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.picturegram.Exceptions.CommentNotFoundException;
import com.nashss.se.picturegram.dynamodb.models.Comment;

import javax.inject.Inject;

public class CommentDao {
    private final DynamoDBMapper dynamoDBMapper;


    @Inject
    public CommentDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDBMapper = dynamoDbMapper;
    }

    public Comment getImageUrl(String imageUrl) {
        Comment comment = this.dynamoDBMapper.load(Comment.class, imageUrl);

        if (comment == null) {
            throw new CommentNotFoundException("Could not find this comment for this image:" + imageUrl);
        }
        return comment;
    }

    public void saveComment(Comment comment) {
        this.dynamoDBMapper.save(comment);
    }

    public void deleteComment(Comment comment) {
        comment.setImageUrl(comment.getImageUrl());
        this.dynamoDBMapper.delete(comment);
    }
}
