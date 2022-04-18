package trivia;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;
    private int currentPlayerIndex = 0;

    public Players() {
        this.players = new ArrayList<>();
    }

    public void addNewPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public String getCurrentPlayerName() {
        return getCurrentPlayer().getName();
    }

    public void applyAPenaltyOnCurrentPlayer() {
        getCurrentPlayer().applyAPenalty();
    }

    public boolean currentPlayerIsInPenaltyBox() {
        return getCurrentPlayer().isInPenaltyBox();
    }

    public boolean currentPlayerHasCorrectlyAnswered() {
        return getCurrentPlayer().isCorrectlyAnswered();
    }

    public void nextPlayerToPlay() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
    }

    public int size() {
        return players.size();
    }

    public int movePlaceBy(int roll) {
        var newPlace = getCurrentPlayer().movePlaceBy(roll);

        out.println(getCurrentPlayerName()
            + "'s new location is "
            + newPlace);
        return newPlace;
    }
}
