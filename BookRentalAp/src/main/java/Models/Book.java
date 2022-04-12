package Models;

public class Book implements java.io.Serializable {
    private String title;
    private int authorId;
    private int categoryId;
    private String releaseYear;

    public Book(){
        this.title = title;
        this.authorId = authorId;
        this.categoryId = authorId;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
