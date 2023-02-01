import java.lang.Math;

public class Deck {

    public Card drawCard() {
        int sut = (int) (Math.random() * 4 + 1);
        int value = (int) (Math.random() * 13 + 1);
        String suit = null;

        switch (sut) {
            case 1:
                suit = "Spades";
                break;

            case 2:
                suit = "Clubs";
                break;

            case 3:
                suit = "Hearts";
                break;

            case 4:
                suit = "Diamonds";
                break;

        }

        return new Card(value, suit);
    }

}
