package uk.co.mould.matt.vocabinator;

public interface QuestionView {
	void setQuestion(String questionWord);

	void setResultToCorrect();

	void setResultToIncorrect(String correction);

    void showNoTensesSelected();

    void showScore(Score score);

    void addSubmitListener(SubmitListener submitListener);

    void addNextQuestionListener(NextQuestionListener nextQuestionListener);

    interface SubmitListener {

        void submitAnswer(String answer);
    }

    interface NextQuestionListener {

        void requestNextQuestion();
    }

}
