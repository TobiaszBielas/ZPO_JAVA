public abstract class BookDecorator implements Publication{
    protected Publication book;

    BookDecorator(Publication new_book) {
        this.book = new_book;
    }

    @Override
    public String getAuthor() {
        return book.getAuthor();
    }

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public int getPagesNumber() {
        return book.getPagesNumber();
    }

    @Override
    public String toString() {
        return book.toString();
    }

    @Override
    public boolean haveCover() {
        return book.haveCover();
    }

    @Override
    public boolean haveDustJacket() {
        return book.haveDustJacket();
    }

    @Override
    public boolean haveAutograph() {
        return book.haveAutograph();
    }
}
