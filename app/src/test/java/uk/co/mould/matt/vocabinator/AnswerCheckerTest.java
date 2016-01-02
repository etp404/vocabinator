package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import java.io.FileNotFoundException;

import uk.co.mould.matt.vocabinator.quiz.AnswerChecking;

import static org.junit.Assert.assertTrue;

public class AnswerCheckerTest {

    @Test
    public void testThatAnswerCheckerReportsCorrectAnswerForCorrectAnswer() {
        AnswerChecker answerChecker = new AnswerChecker();
        CapturingCallback capturingCallback = new CapturingCallback();
        answerChecker.check("hello", "hello", capturingCallback);
        assertTrue(capturingCallback.correctCalled);
    }

    private static class CapturingCallback implements AnswerChecking.Callback {
        public boolean correctCalled = false;

        @Override
        public void correct() {
            correctCalled = true;
        }

        @Override
        public void incorrect(String corrrection) {

        }
    }

    private class AnswerChecker implements AnswerChecking {
        @Override
        public void check(String userAnswer, String correctAnswer, Callback callback) {
            if (correctAnswer.equals(userAnswer)) {
                callback.correct();
            }
        }
    }
}
