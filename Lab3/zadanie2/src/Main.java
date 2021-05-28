public class Main {
    public static void main(String[] args) {
        try {
            Publication k1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 340);
            Publication k2 = new Book("Adam Mickiewicz", "Dziady", 130);
            Publication kk1 = new BookSoftCover(k1);
            Publication kk2 = new BookHardCover(k2);
            Publication fakeBook = new BookDustJacket(k1);
            // wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki
            Publication kkk2 = new BookDustJacket(kk2); // a tu OK
            Publication odrzut = new BookDustJacket(kkk2);
            // wyjątek! Obwoluta może być jedna
            Publication dziadyZAutografemWieszcza = new AutographedBook(kk2, "Drogiej Hani - Adam Mickiewicz");
            System.out.println(dziadyZAutografemWieszcza);
            // wypisuje: | Adam Mickiewicz | Dziady | 130 | Okładka twarda | Drogiej Hani -Adam Mickiewicz |
            Publication dziadyZDwomaAutografami = new AutographedBook(dziadyZAutografemWieszcza, "Haniu, to nieprawda, Dziady napisałem ja, Julek Słowacki!");
            // wyjątek! Autograf może być tylko jeden
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}
