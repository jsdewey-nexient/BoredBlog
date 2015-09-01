package com.boredblog.jsonview;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * An interface defining JSON views regarding Authors.
 */
public interface AuthorJsonView {
    interface LimitedAuthor {}
    interface FullAuthor extends LimitedAuthor, CommentJsonView.FullComment {}
}
