package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String comment ;


    public Solution(long solutionId, String comment) {
        this.commentId = solutionId;
        this.comment = comment;

    }

    public Solution() {

    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}