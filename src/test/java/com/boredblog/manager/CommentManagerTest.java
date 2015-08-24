package com.boredblog.manager;

import com.boredblog.entity.Comment;
import com.boredblog.repository.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify the behavior of the CommentManager.
 */
public class CommentManagerTest {
    private final Integer POST_ID = 1;
    private final Integer COMMENT_ID = 1;
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentManager commentManager;
    private Comment comment;
    private List<Comment> commentList;
    private Comment updatedComment;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        instantiateDependencies();
        mockCommentRepository();
        setCommentProperties();
    }

    @Test
    public void testCreateComment() {
        Comment result = this.commentManager.create(POST_ID, this.comment);

        assertEquals(
                "testCreateComment did not receive the same Comment object back.",
                this.comment,
                result
        );
    }

    @Test
    public void testUpdatingComment() {
        String originalValue = comment.getContent();
        String updatedValue = null;
        this.commentManager.update(
                POST_ID,
                COMMENT_ID,
                updatedComment
        );
        updatedValue = comment.getContent();

        assertNotEquals(
                "testUpdatingComment received the same content string back.",
                originalValue,
                updatedValue
        );

        assertNotEquals(
                "testUpdatingComment receive null as the updated content.",
                null,
                updatedValue
        );
    }

    private void instantiateDependencies() {
        this.comment = new Comment();
        this.commentList = new ArrayList<Comment>();
        this.updatedComment = new Comment();
    }

    private void setCommentProperties() {
        this.comment.setContent("Hello!");
        this.updatedComment.setContent("Good bye!");
    }

    private void mockCommentRepository() {
        Mockito.when(this.commentRepository.save(this.comment))
                .thenReturn(this.comment);
        Mockito.when(this.commentRepository.findOne(COMMENT_ID))
                .thenReturn(this.comment);
        Mockito.when(this.commentRepository.findAll())
                .thenReturn(this.commentList);
    }
}
