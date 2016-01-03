package uk.co.mould.matt.vocabinator.quiz;

import uk.co.mould.matt.vocabinator.quiz.AnswerChecking;

public class AnswerChecker implements AnswerChecking {
    @Override
    public void check(String correctAnswer, String userAnswer, Callback callback) {
        if (correctAnswer.equals(userAnswer)) {
            callback.correct();
        }
        else {
            callback.incorrect();
        }
    }
}
