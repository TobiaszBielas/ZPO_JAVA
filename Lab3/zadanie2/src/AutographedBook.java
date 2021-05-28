public class AutographedBook extends BookDecorator{
    private String autograph;
    public AutographedBook(Publication new_book, String new_autograph) throws PublicationException {
        super(new_book);
        if(!super.haveAutograph()) this.autograph= new_autograph;
        else throw new PublicationException("have autograph");
    }

    @Override
    public String toString() {
        return super.toString() + " |" + this.autograph + "|";
    }

    @Override
    public boolean haveAutograph() {
        return true;
    }
}
