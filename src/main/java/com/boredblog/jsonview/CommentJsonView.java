package com.boredblog.jsonview;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * Limits the information delivered regarding a comment.
 */
public interface CommentJsonView {
    interface ShowCommentDetail
            extends BaseJsonView, UserJsonView.UserScreenName {}
}
