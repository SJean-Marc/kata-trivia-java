package trivia;

import static java.lang.System.out;

class Player {
    private final String name;
    private int place;
    private int coins;
    private boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        place = 0;
        coins = 0;
        inPenaltyBox = false;
    }

    public String getName() {
        return name;
    }

    public int movePlaceBy(int incrementedPlace) {
        place += incrementedPlace;
        if (place > 11) {
            place -= 12;
        }
        return place;
    }

    public int getCoins() {
        return coins;
    }

    public void addOneCoin() {
        this.coins++;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void applyAPenalty() {
        inPenaltyBox = true;
    }

    public boolean hadWin() {
        return coins != 6;
    }

    public boolean isCorrectlyAnswered() {
        addOneCoin();
        out.println(getName()
            + " now has "
            + getCoins()
            + " Gold Coins.");

        return hadWin();
    }
}
