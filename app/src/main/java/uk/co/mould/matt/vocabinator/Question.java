package uk.co.mould.matt.vocabinator;

public class Question {
    public final String questionWord;
    public final String correctAnswer;

    public Question(String questionWord, String correctAnswer) {
        this.questionWord = questionWord;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionWord != null ? !questionWord.equals(question.questionWord) : question.questionWord != null)
            return false;
        return correctAnswer != null ? correctAnswer.equals(question.correctAnswer) : question.correctAnswer == null;

    }

    @Override
    public int hashCode() {
        int result = questionWord != null ? questionWord.hashCode() : 0;
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        return result;
    }
}
