package uk.co.mould.matt.vocabinator;

public class QuestionPresenter {
    private final QuestionView questionView;
    private final QuestionGenerator questionGenerator;
    private Score score = new Score();
    private String questionWord;

    public QuestionPresenter(QuestionView questionView, QuestionGenerator questionGenerator, final AnswerChecking answerChecking) {
        this.questionView = questionView;
        this.questionGenerator = questionGenerator;

        questionView.addSubmitListener(new QuestionView.SubmitListener() {
            @Override
            public void submitAnswer(String answer) {
                answerChecking.check(questionWord, answer, new AnswerChecking.Callback() {
                    @Override
                    public void correct() {
                        score.addCorrect();
                        QuestionPresenter.this.questionView.setResultToCorrect();
                    }

                    @Override
                    public void incorrect(String corrrection) {
                        score.addIncorrect();
                        QuestionPresenter.this.questionView.setResultToIncorrect(corrrection);
                    }
                });
            }
        });

        questionView.addNextQuestionListener(new QuestionView.NextQuestionListener() {
            @Override
            public void requestNextQuestion() {
                showQuestion();
            }
        });
        showQuestion();
    }

    public void showQuestion() {
        questionGenerator.getQuestion(new Callback() {
            @Override
            public void questionProvided(String questionWord) {
                QuestionPresenter.this.questionWord = questionWord;
                questionView.showScore(score);
                questionView.setQuestion(questionWord);
            }
        });
    }
}
