package uk.co.mould.matt.vocabinator;


import org.junit.Before;
import org.junit.Test;


import uk.co.mould.matt.vocabinator.fakes.FakeQuestionView;
import uk.co.mould.matt.vocabinator.quiz.AnswerChecking;
import uk.co.mould.matt.vocabinator.quiz.QuestionGenerator;
import uk.co.mould.matt.vocabinator.quiz.QuestionPresenter;
import uk.co.mould.matt.vocabinator.quiz.Score;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public final class QuestionPresenterTest {

	private final String correctAnswer = "correct answer";
    private final String wrongAnswer = "wrong answer";

	private FakeQuestionView questionView;
    private String questionWord = "question word";
    private Question question = new Question(questionWord, correctAnswer);

    @Before
	public void setup() {
		questionView = new FakeQuestionView();

        AnswerChecking answerChecker = new FakeAnswerChecker();

        QuestionGenerator fakeQuestionGenerator = new FakeQuestionGenerator(question);
        new QuestionPresenter(
				questionView,
                fakeQuestionGenerator,
                answerChecker);
	}

	@Test
	public void testThatViewCanBeToldToShowAQuestion() {
        assertEquals(questionView.setQuestionCalledWithQuestion, question.questionWord);
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
        private Question question;

        public FakeQuestionGenerator(Question question) {
            this.question = question;
        }

        @Override
        public void getQuestion(Callback callback) {
            callback.questionProvided(question);
        }

    }

    public class FakeAnswerChecker implements AnswerChecking {

        @Override
        public void check(String userAnswer, String correctAnswer, Callback callback) {
            if (userAnswer.equals(correctAnswer)) {
                callback.correct();
            }
            else {
                callback.incorrect(correctAnswer);
            }
        }
    }

}
