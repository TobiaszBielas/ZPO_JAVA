public interface Publication {
    public String getAuthor();
    public String getTitle();
    public int getPagesNumber();

    public default boolean haveCover() {return false;}
    public default boolean haveDustJacket() {return false;}
    public default boolean haveAutograph() {return false;}
}
