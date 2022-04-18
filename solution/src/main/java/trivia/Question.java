package trivia;

import static java.lang.System.out;

import java.util.LinkedList;
import java.util.List;

class Question {
    List<String> popQuestions = new LinkedList<>();
    List<String> scienceQuestions = new LinkedList<>();
    List<String> sportsQuestions = new LinkedList<>();
    List<String> rockQuestions = new LinkedList<>();

    public Question() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
    }

    public void askQuestion(QuestionCategoryType categoryType) {
        switch (categoryType) {
            case POP -> out.println(popQuestions.remove(0));
            case SCIENCE -> out.println(scienceQuestions.remove(0));
            case SPORTS -> out.println(sportsQuestions.remove(0));
            case ROCK -> out.println(rockQuestions.remove(0));
            default -> throw new IllegalStateException(
                "Unexpected value: " + categoryType.getLabel());
        }
    }

    public QuestionCategoryType currentCategory(int playerPlaceInBoard) {
        return switch (playerPlaceInBoard) {
            case 0, 4, 8 -> QuestionCategoryType.POP;
            case 1, 5, 9 -> QuestionCategoryType.SCIENCE;
            case 2, 6, 10 -> QuestionCategoryType.SPORTS;
            default -> QuestionCategoryType.ROCK;
        };
    }
}
