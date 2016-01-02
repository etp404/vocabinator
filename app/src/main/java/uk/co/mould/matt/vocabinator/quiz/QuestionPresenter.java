package uk.co.mould.matt.vocabinator.quiz;

import uk.co.mould.matt.vocabinator.Question;

public class QuestionPresenter {
    private final QuestionView questionView;
    private final QuestionGenerator questionGenerator;
    private Score score = new Score();
    private Question question;

    public QuestionPresenter(QuestionView questionView, QuestionGenerator questionGenerator, final AnswerChecking answerChecking) {
        this.questionView = questionView;
        this.questionGenerator = questionGenerator;

        questionView.addSubmitListener(new QuestionView.SubmitListener() {
            @Override
            public void submitAnswer(String userAnswer) {
                answerChecking.check(userAnswer, question.correctAnswer, new AnswerChecking.Callback() {
                    @Override
                    public void correct() {
                        score.addCorrect();
                        QuestionPresenter.this.questionView.setResultToCorrect();
                    }

                    @Override
                    public void incorrect() {
                        score.addIncorrect();
                        QuestionPresenter.this.questionView.setResultToIncorrect(question.correctAnswer);
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
        questionGenerator.getQuestion(new QuestionGenerator.Callback() {
            @Override
            public void questionProvided(Question question) {
                QuestionPresenter.this.question = question;
                questionView.showScore(score);
                questionView.setQuestion(question.questionWord);
            }
        });
    }
}
