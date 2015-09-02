package com.boredblog.jsonview;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * An interface defining JSON views regarding Authors.
 */
public interface AuthorJsonView {
    interface AuthorScreenName {}
    interface ListAuthors
            extends AuthorScreenName,
                BaseJsonView {}
    interface ShowAuthorDetail
            extends CommentJsonView.ShowCommentDetail,
                ListAuthors,
                PostJsonView.ShowPostDetail {}
}
