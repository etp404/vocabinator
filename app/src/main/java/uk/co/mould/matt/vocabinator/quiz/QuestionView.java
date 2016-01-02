package uk.co.mould.matt.vocabinator.quiz;

public interface QuestionView {
	void setQuestion(String questionWord);

	void setResultToCorrect();

	void setResultToIncorrect(String correction);

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
