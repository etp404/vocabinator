package uk.co.mould.matt.vocabinator;

import android.content.Context;
import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import uk.co.mould.matt.vocabinator.quiz.AndroidQuestionView;
import uk.co.mould.matt.vocabinator.quiz.QuestionView;
import uk.co.mould.matt.vocabinator.quiz.Score;

public final class AndroidQuestionViewTest extends AndroidTestCase {
    public AndroidQuestionView questionView;
    private TextView scoreBox;
    private View submitButton;
    private View nextButton;
    private TextView answerBox;
    private TextView questionBox;
    private TextView resultBox;
    private TextView correctionBox;
    private View noTenseSelectedWarning;
    private String questionWord = "bonjour";
    private String answerWord = "hello";
    private View greenTick;
    private View redCross;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Context context = getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        questionView = (AndroidQuestionView) layoutInflater.inflate(R.layout.question_layout, null);
        scoreBox = (TextView) questionView.findViewById(R.id.score);
        submitButton = questionView.findViewById(R.id.submit_button);
        nextButton = questionView.findViewById(R.id.next_button);
        answerBox = (TextView) questionView.findViewById(R.id.answer_box);
        questionBox = (TextView) questionView.findViewById(R.id.question);
        resultBox = (TextView) questionView.findViewById(R.id.result_box);
        correctionBox = (TextView) questionView.findViewById(R.id.correction_box);
        noTenseSelectedWarning = questionView.findViewById(R.id.no_tenses_selected);
        greenTick = questionView.findViewById(R.id.green_tick);
        redCross = questionView.findViewById(R.id.red_cross);

        questionView.setQuestion(questionWord);
    }

    public void testThatScoreIsShownAsExpected() {
        Score score = new Score();
        questionView.showScore(score);
        assertEquals(score.toString(), scoreBox.getText());
    }

    public void testThatQuestionDisplayedCorrectly() {
        questionView.setQuestion(questionWord);

        String expectedQuestion = String.format("What is the translation of %s?", questionWord);

        assertTrue(submitButton.isEnabled());
        assertEquals(submitButton.getVisibility(), View.VISIBLE);

        assertTrue(nextButton.isEnabled());
        assertTrue(answerBox.isEnabled());
        assertEquals(expectedQuestion, questionBox.getText());
        assertEquals(resultBox.getVisibility(), View.GONE);

    }

    public void testThatCorrectAnswerIsShownCorrectly() {
        questionView.setResultToCorrect();

        assertEquals("Correct", resultBox.getText());
        assertEquals(View.VISIBLE, resultBox.getVisibility());
        assertFalse(answerBox.isEnabled());
        assertEquals(correctionBox.getVisibility(), View.GONE);
        assertEquals(greenTick.getVisibility(), View.VISIBLE);

        assertEquals(submitButton.getVisibility(), View.GONE);

        assertEquals(nextButton.getVisibility(), View.VISIBLE);
        assertTrue(nextButton.isEnabled());

    }

    public void testThatIncorrectAnswerDisplayedCorrectly() {

        questionView.setResultToIncorrect(answerWord);

        assertEquals("Incorrect", resultBox.getText());
        assertEquals(resultBox.getVisibility(), View.VISIBLE);

        assertFalse(answerBox.isEnabled());
        assertEquals(answerWord, correctionBox.getText());
        assertEquals(View.VISIBLE, correctionBox.getVisibility());
        assertEquals(greenTick.getVisibility(), View.GONE);
        assertEquals(redCross.getVisibility(), View.VISIBLE);

        assertEquals(submitButton.getVisibility(), View.GONE);

        assertEquals(nextButton.getVisibility(), View.VISIBLE);
        assertTrue(nextButton.isEnabled());

    }

    public void testThatWhenIncorrectAnswerHasBeenShown_AndNextQuestionIsRequested_QuestionModeIsReentered() {

        questionView.setResultToIncorrect(answerWord);
        answerBox.setText("some answer");
        questionView.setQuestion(questionWord);

        assertEquals(correctionBox.getVisibility(), View.GONE);
        assertEquals(submitButton.getVisibility(), View.VISIBLE);
        assertEquals(nextButton.getVisibility(), View.GONE);
        assertEquals(redCross.getVisibility(), View.GONE);
        assertTrue(nextButton.isEnabled());
        assertTrue(answerBox.isEnabled());
        assertEquals(0, answerBox.getText().length());
    }

    public void testThatWhenCorrectAnswerHasBeenShown_AndNextQuestionIsRequested_QuestionModeIsReentered() {
        questionView.setResultToCorrect();
        questionView.setQuestion(questionWord);

        assertEquals(correctionBox.getVisibility(), View.GONE);
        assertEquals(submitButton.getVisibility(), View.VISIBLE);
        assertEquals(nextButton.getVisibility(), View.GONE);
        assertEquals(greenTick.getVisibility(), View.GONE);
        assertTrue(nextButton.isEnabled());
        assertTrue(answerBox.isEnabled());
        assertEquals(0, answerBox.getText().length());
    }

    public void testThatPressingSubmitInvokesListener() {
        FakeSubmitListener submitListener = new FakeSubmitListener();
        questionView.addSubmitListener(submitListener);
        String answer = "some_answer";
        answerBox.setText(answer);
        submitButton.performClick();
        assertEquals(submitListener.invokedWith, answer);
    }

    public void testThatPressingNextInvokesListener() {
        FakeNextQuestionListener fakeNextQuestionListener = new FakeNextQuestionListener();
        questionView.addNextQuestionListener(fakeNextQuestionListener);
        nextButton.performClick();
        assertTrue(fakeNextQuestionListener.invoked);
    }

    private static class FakeSubmitListener implements QuestionView.SubmitListener {
        public String invokedWith;

        @Override
        public void submitAnswer(String answer) {
            invokedWith = answer;
        }
    }

    private static class FakeNextQuestionListener implements QuestionView.NextQuestionListener {
        public boolean invoked = false;

        @Override
        public void requestNextQuestion() {
            invoked = true;
        }
    }
}
