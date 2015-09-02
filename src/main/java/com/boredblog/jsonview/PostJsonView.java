package com.boredblog.jsonview;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * A JsonView for Posts.
 */
public interface PostJsonView {
    interface ListPosts extends UserJsonView.UserScreenName, BaseJsonView {}
    interface ShowPostDetail extends ListPosts {}
}
