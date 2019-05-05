import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Book_Successful() {

        // Arrange
        String name = "name";
        String author = "author";

        // Act
        Book book = new Book(name, author);

        //Assert
        Assert.assertEquals(name, book.getName());
        Assert.assertEquals(author, book.getAuthor());
    }

    @Test
    public void Book_ThrowsIllegalArugmentException_WhenNameIsNull(){

        // Arrange
        String name = null;
        String author = "author";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot create a book without a name");

        // Act
        Book book = new Book(name, author);
    }

    @Test
    public void Book_ThrowsIllegalArgumentException_WhenNameIsEmpty(){

        // Arrange
        String name = "";
        String author = "author";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot create a book without a name");

        // Act
        Book book = new Book(name, author);
    }

    @Test
    public void Book_ThrowsIllegalArugmentException_WhenAuthorIsNull(){

        // Arrange
        String name = "name";
        String author = null;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot create a book without an author");

        // Act
        Book book = new Book(name, author);
    }

    @Test
    public void Book_ThrowsIllegalArgumentException_WhenAuthorIsEmpty(){

        // Arrange
        String name = "name";
        String author = "";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot create a book without an author");

        // Act
        Book book = new Book(name, author);
    }

    @Test
    public void AddChapter_Successfull(){

        // Arrange
        Chapter chapter = new Chapter("Mocking", "1.1");
        Book book = new Book("Testing", "A Programmer");

        // Act
        book.AddChapter(chapter);

        // Assert
        Assert.assertEquals(1, book.getChapterList().size());
        Assert.assertEquals(chapter.getNumber(), book.getChapterList().get(0).getNumber());
        Assert.assertEquals(chapter.getName(), book.getChapterList().get(0).getName());
    }

    @Test
    public void AddChapter_ThrownIllegalArgumentException_WhenChapterNameIsEmpty(){

        //Arrange
        Chapter chapter = new Chapter("name", "author");
        chapter.setName("");
        Book book = new Book("name", "author");

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot add a chapter without a name");

        // Act
        book.AddChapter(chapter);
    }

    @Test
    public void AddChapter_ThrownIllegalArgumentException_WhenChapterNumberIsEmpty(){

        //Arrange
        Chapter chapter = new Chapter("name", "author");
        chapter.setNumber("");
        Book book = new Book("name", "author");

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot add a chapter without a number");

        // Act
        book.AddChapter(chapter);
    }

    @Test
    public void GetTableOfContents_ReturnsSortedListOfChapters_Successful(){

        // Arrange
        Book book = new Book("name", "author");
        Chapter firstChapter = new Chapter("Chapter 1", "1");
        Chapter secondChapter = new Chapter("Chapter 2", "2");

        book.AddChapter(secondChapter);
        book.AddChapter(firstChapter);

        // Act
        List<Chapter> result = book.GetTableOfContents();

        // Assert
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(result.get(0).getName(), firstChapter.getName());
        Assert.assertEquals(result.get(0).getNumber(), firstChapter.getNumber());
        Assert.assertEquals(result.get(1).getName(), secondChapter.getName());
        Assert.assertEquals(result.get(1).getNumber(), secondChapter.getNumber());
    }
}