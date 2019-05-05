import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    private String Name;
    private String Author;
    private List<Chapter> chapterList;

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return Author;
    }

    public Book(String name, String author) {

        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Cannot create a book without a name");
        }

        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("Cannot create a book without an author");
        }

        Name = name;
        Author = author;
        chapterList = new ArrayList<>();
    }

    public void AddChapter(Chapter chapter){

        if (chapter.getName() == null || chapter.getName().isEmpty()){
            throw new IllegalArgumentException("Cannot add a chapter without a name");
        }

        if (chapter.getNumber() == null || chapter.getNumber().isEmpty()){
            throw new IllegalArgumentException("Cannot add a chapter without a number");
        }

        chapterList.add(chapter);
    }

    public List<Chapter> GetTableOfContents(){
        Collections.sort(chapterList);
        return chapterList;
    }
}
