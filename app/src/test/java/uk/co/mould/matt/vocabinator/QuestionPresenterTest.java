package uk.co.mould.matt.vocabinator;


import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import uk.co.mould.matt.vocabinator.fakes.FakeQuestionView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public final class QuestionPresenterTest {

	private final String correctAnswer = "correct answer";
    private final String wrongAnswer = "wrong answer";

	private final String correctAnswerWithTrailingSpace = "correct answer ";
	private FakeQuestionView questionView;
    private String questionWord = "question word";

    @Before
	public void setup() {
		questionView = new FakeQuestionView();

        AnswerChecking answerChecker = new FakeAnswerChecker(
                new HashMap<String, String>(){{
                    put(questionWord, correctAnswer);
                }});

        QuestionGenerator fakeQuestionGenerator = new FakeQuestionGenerator(questionWord);
        new QuestionPresenter(
				questionView,
                fakeQuestionGenerator,
                answerChecker);
	}

	@Test
	public void testThatViewCanBeToldToShowAQuestion() {
		assertEquals(questionView.setQuestionCalledWithQuestion, questionWord);
        assertThat(questionView.updatedScore, is(new Score()));
    }

	@Test
	public void testThatViewCanBeToldToShowWhenAnswerIsIncorrectAnswer() {
        questionView.submitListener.submitAnswer(wrongAnswer);
        Score expectedScore = new Score();
        expectedScore.addIncorrect();

        assertEquals(questionView.toldToShowIncorrectWithCorrection, correctAnswer);
        assertThat(questionView.updatedScore, is(expectedScore));
    }

	@Test
	public void testThatQuestionIsShownInResponseToNextQuestion() {
        questionView.setQuestionCalledWithQuestion = null;
        questionView.nextQuestionListener.requestNextQuestion();
        assertEquals(questionView.setQuestionCalledWithQuestion, questionWord);
    }

    @Test
    public void testThatScoreIsSetToTwoOfTwoIfTwoCorrectAnswersGiven() {
        questionView.submitListener.submitAnswer(correctAnswer.toString());
        questionView.submitListener.submitAnswer(correctAnswer.toString());

        Score expectedScore = new Score();
        expectedScore.addCorrect();
        expectedScore.addCorrect();
        assertThat(questionView.updatedScore, is(expectedScore));
    }

    @Test
    public void testThatScoreIsSetToOneOfTwoIfOneCorrectAndTwoIncorrectAnswersGiven() {
        questionView.submitListener.submitAnswer("wrong answer");
        questionView.submitListener.submitAnswer("wrong answer");
        questionView.submitListener.submitAnswer(correctAnswer.toString());

        Score expectedScore = new Score();
        expectedScore.addCorrect();
        expectedScore.addIncorrect();
        expectedScore.addIncorrect();
        assertThat(questionView.updatedScore, is(expectedScore));
    }

    public class FakeQuestionGenerator implements QuestionGenerator {
        private String questionWord;

        public FakeQuestionGenerator(String questionWord) {
            this.questionWord = questionWord;
        }

        @Override
        public void getQuestion(Callback callback) {
            callback.questionProvided(questionWord);
        }

    }

    public class FakeAnswerChecker implements AnswerChecking {

        private Map<String, String> questionToAnswer;

        public FakeAnswerChecker(Map<String, String> questionToAnswer) {
            this.questionToAnswer = questionToAnswer;
        }

        @Override
        public void check(String questionWord, String answer, Callback callback) {
            String rightAnswer = questionToAnswer.get(questionWord);
            if (answer.equals(rightAnswer.toString())) {
                callback.correct();
            }
            else {
                callback.incorrect(rightAnswer);
            }
        }
    }

}
