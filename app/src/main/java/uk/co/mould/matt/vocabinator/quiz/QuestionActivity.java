package uk.co.mould.matt.vocabinator.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.mould.matt.vocabinator.R;

public class QuestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        AndroidQuestionView questionView = (AndroidQuestionView) findViewById(R.id.android_question_view);
        new QuestionPresenter(questionView, new QuestionGenerator() {
            @Override
            public void getQuestion(Callback callback) {
                callback.questionProvided(null);
            }
        },
                new AnswerChecking() {
                    @Override
                    public void check(String questionWord, String answer, Callback callback) {
                        callback.correct();
                    }
                });
    }
}
