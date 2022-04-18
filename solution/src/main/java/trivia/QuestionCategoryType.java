package trivia;

enum QuestionCategoryType {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    private final String label;

    QuestionCategoryType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
