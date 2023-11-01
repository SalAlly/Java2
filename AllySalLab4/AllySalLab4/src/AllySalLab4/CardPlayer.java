package AllySalLab4;

import java.util.ArrayList;
import java.util.List;

class CardPlayer {
    private List<Card> hand;

    public CardPlayer() {
        hand = new ArrayList<>();
    }

    public void getCard(Card card) {
        hand.add(card);
    }

    public void showCards() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}
