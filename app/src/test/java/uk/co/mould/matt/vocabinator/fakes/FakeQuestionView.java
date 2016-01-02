package uk.co.mould.matt.vocabinator.fakes;

import uk.co.mould.matt.vocabinator.quiz.QuestionView;
import uk.co.mould.matt.vocabinator.quiz.Score;

public class FakeQuestionView implements QuestionView {
	public String setQuestionCalledWithQuestion;
    public Boolean noTensesSelectedIsShown;
    public Score updatedScore;
	public QuestionView.SubmitListener submitListener;
	public boolean toldToShowThatAnswerWasCorrect;
	public String correction;
	public NextQuestionListener nextQuestionListener;
    public String toldToShowIncorrectWithCorrection;

    @Override
	public void setQuestion(String questionWord) {
		this.setQuestionCalledWithQuestion = questionWord;
	}

	@Override
	public void setResultToCorrect() {
		toldToShowThatAnswerWasCorrect = true;
	}

	@Override
	public void setResultToIncorrect(String correction) {
		toldToShowIncorrectWithCorrection = correction;
	}

    @Override
    public void showNoTensesSelected() {
        noTensesSelectedIsShown = true;
    }

    @Override
    public void showScore(Score score) {
        updatedScore = score;
    }

	@Override
	public void addSubmitListener(SubmitListener submitListener) {
		this.submitListener = submitListener;
	}

	@Override
	public void addNextQuestionListener(NextQuestionListener nextQuestionListener) {
		this.nextQuestionListener = nextQuestionListener;
	}
}
