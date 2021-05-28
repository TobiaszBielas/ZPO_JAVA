public class BookSoftCover extends BookDecorator{
    BookSoftCover(Publication new_book) throws PublicationException{
        super(new_book);
        if(super.haveCover()) throw new PublicationException("have cover");
    }

    @Override
    public boolean haveCover() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "Have Soft Cover";
    }
}