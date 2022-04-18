package trivia;

import static java.lang.System.out;

public class Game implements IGame {
    final Players players;
    final Question question;

    boolean isGettingOutOfPenaltyBox;

    public Game() {
        players = new Players();
        question = new Question();
    }

    public void add(String playerName) {
        players.addNewPlayer(playerName);
        out.println(playerName + " was added");
        out.println("They are player number " + players.size());
    }

    public void roll(int roll) {
        rollForPlayer(roll);
    }

    private void rollForPlayer(int roll) {
        var currentPlayerName = players.getCurrentPlayerName();
        out.println(currentPlayerName + " is the current player");
        out.println("They have rolled a " + roll);

        if (players.currentPlayerIsInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                out.println(currentPlayerName + " is getting out of the penalty box");
                incrementPlaceBy(roll);
            } else {
                out.println(currentPlayerName + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            incrementPlaceBy(roll);
        }
    }

    private void incrementPlaceBy(int roll) {
        var newPlaceInBoard = players.movePlaceBy(roll);
        var questionCategoryType = question.currentCategory(newPlaceInBoard);
        out.println("The category is " + questionCategoryType.getLabel());
        question.askQuestion(questionCategoryType);
    }

    public boolean wasCorrectlyAnswered() {
        var correctlyAnswered = true;
        if (players.currentPlayerIsInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                out.println("Answer was correct!!!!");
                correctlyAnswered = players.currentPlayerHasCorrectlyAnswered();
            }
        } else {
            out.println("Answer was corrent!!!!");
            correctlyAnswered = players.currentPlayerHasCorrectlyAnswered();
        }
        players.nextPlayerToPlay();
        return correctlyAnswered;
    }

    public boolean wrongAnswer() {
        out.println("Question was incorrectly answered");
        out.println(players.getCurrentPlayerName() + " was sent to the penalty box");

        players.applyAPenaltyOnCurrentPlayer();
        players.nextPlayerToPlay();
        return true;
    }
}
