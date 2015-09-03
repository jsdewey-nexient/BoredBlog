package com.boredblog.manager;

import com.boredblog.entity.Author;
import com.boredblog.repository.AuthorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the AuthorManager works as intended.
 */
public class AuthorManagerTest {
    private final Integer AUTHOR_ID = 1;
    private final Integer UPDATE_AUTHOR_ID = 2;
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private List<Author> authors;
    @InjectMocks
    private AuthorManager authorManager;
    private Author author;
    private Author partialAuthor;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        createDependentObjects();
        setDependentObjectProperties();
        this.mockAuthorRepository();
    }

    @Test
    public void testCreateAuthor() {
        Author result = this.authorManager.create(this.author);

        assertEquals(
                "testCreateAuthor did not receive the same Author object back.",
                this.author,
                result
        );
    }

    @Test
    public void testRetrievingSingleAuthor() {
        Author result = this.authorManager.retrieve(AUTHOR_ID);

        assertEquals(
                "testRetrievingAuthor did not receive expected Author object.",
                this.author,
                result
        );
    }

    @Test
    public void testRetrievingAllAuthors() {
        List<Author> result = this.authorManager.retrieveAll();

        assertEquals(
                "testRetrievingAllAuthors did not receive the expected " +
                        "List of Author objects.",
                this.authors,
                result
        );
    }

    /**
     * @note The properties set need to be compared as the object that
     * BeanUtils.copyProperties is different than the one that is inserted.
     */
    @Test
    public void testUpdatingAuthor() {
        String originalFirstName = this.author.getFirstName();
        String updatedFirstName = null;
        this.authorManager.update(
                AUTHOR_ID,
                this.partialAuthor
        );
        updatedFirstName = this.author.getFirstName();

        assertNotEquals(
                "testUpdatingAuthor received a null string back.",
                null,
                updatedFirstName
        );

        assertNotEquals(
                "testUpdatingAuthor received the same first name back.",
                originalFirstName,
                updatedFirstName
        );
    }

    private void createDependentObjects() {
        this.author = new Author();
        this.partialAuthor = new Author();
    }

    private void setDependentObjectProperties() {
        this.author.setFirstName("Johnson");
        this.partialAuthor.setFirstName("Johnny");
    }

    private void mockAuthorRepository() {
        Mockito.when(this.authorRepository.findOne(AUTHOR_ID))
                .thenReturn(this.author);
        Mockito.when(this.authorRepository.findAll())
                .thenReturn(this.authors);
        Mockito.when(this.authorRepository.save(this.author))
                .thenReturn(this.author);
    }
}
