public class BookDustJacket extends BookDecorator{
    BookDustJacket(Publication new_book) throws PublicationException{
        super(new_book);
        if(super.haveDustJacket()) throw new PublicationException("Have Dust Jacket");
        if(!super.haveCover()) throw new PublicationException("without cover");
    }

    @Override
    public String toString() {
        return super.toString() + "Have Dust Jacket";
    }

    @Override
    public boolean haveDustJacket() {
        return true;
    }
}
