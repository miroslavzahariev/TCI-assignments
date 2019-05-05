import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ChapterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Chapter_Successful(){

        // Arrange
        String name = "How To Mock";
        String number = "5.1";

        // Act
        Chapter chapter = new Chapter(name, number);

        // Assert
        Assert.assertEquals(name, chapter.getName());
        Assert.assertEquals(number, chapter.getNumber());
    }

    @Test
    public void Chapter_ThrowsIllegalArgumentException_WhenNameIsNull(){

        // Arrange
        String name = null;
        String number = "4.4";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot create a chapter without a name");

        // Act
        Chapter chapter = new Chapter(name, number);
    }

    @Test
    public void Chapter_ThrowsIllegalArgumentException_WhenNumberHasMoreThanTwoSections(){

        //Arrange
        String name = "Valid Chapter";
        String number = "4.4.4";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Cannot create a chapter with number longer than two sections");

        //Act
        Chapter chapter = new Chapter(name, number);
    }

    @Test
    public void VerifyChapterImplementsIComparable(){

        // Arrange
        Chapter chapter = new Chapter ("chapter", "1");

        // Act
        boolean result = chapter instanceof Comparable;

        Assert.assertTrue(result);
    }
}