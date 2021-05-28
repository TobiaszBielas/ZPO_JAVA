public class Book implements Publication {
    private String author;
    private String title;
    private int pages_number;

    Book(String new_author, String new_title, int new_pages_number) {
        this.author = new_author;
        this.title = new_title;
        this.pages_number = new_pages_number;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getPagesNumber() {
        return pages_number;
    }

    @Override
    public String toString() {
        return "|" + author + "|" + title + " |" + pages_number + "|";
    }
}
