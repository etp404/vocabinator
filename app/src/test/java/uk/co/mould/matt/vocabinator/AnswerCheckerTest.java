package uk.co.mould.matt.vocabinator;

import org.junit.Before;
import org.junit.Test;

import uk.co.mould.matt.vocabinator.quiz.AnswerChecker;
import uk.co.mould.matt.vocabinator.quiz.AnswerChecking;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnswerCheckerTest {

    private String rightAnswer = "hello";
    private AnswerChecker answerChecker;
    private CapturingCallback capturingCallback;

    @Before
    public void setUp() throws Exception {
        answerChecker = new AnswerChecker();
        capturingCallback = new CapturingCallback();
    }

    @Test
    public void testThatAnswerCheckerReportsCorrectAnswerForCorrectAnswer() {
        answerChecker.check(rightAnswer, rightAnswer, capturingCallback);
        assertTrue(capturingCallback.correctCalled);
    }

    @Test
    public void testThatAnswerCheckerGivesCorrectIfReceivesIncorrectAnswer() {
        answerChecker.check(rightAnswer, "wrong answer", capturingCallback);
        assertTrue(capturingCallback.incorrectCalled);
    }

    private static class CapturingCallback implements AnswerChecking.Callback {
        public boolean correctCalled = false;
        public boolean incorrectCalled = false;

        @Override
        public void correct() {
            correctCalled = true;
        }

        @Override
        public void incorrect() {
            incorrectCalled = true;
        }
    }

}
