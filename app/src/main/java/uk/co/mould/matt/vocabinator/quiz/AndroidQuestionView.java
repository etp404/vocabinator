package uk.co.mould.matt.vocabinator.quiz;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class AndroidQuestionView extends LinearLayout implements QuestionView {
    public AndroidQuestionView(Context context) {
        super(context);
    }

    public AndroidQuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AndroidQuestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setQuestion(String questionWord) {

    }

    @Override
    public void setResultToCorrect() {

    }

    @Override
    public void setResultToIncorrect(String correction) {

    }

    @Override
    public void showNoTensesSelected() {

    }

    @Override
    public void showScore(Score score) {

    }

    @Override
    public void addSubmitListener(SubmitListener submitListener) {

    }

    @Override
    public void addNextQuestionListener(NextQuestionListener nextQuestionListener) {

    }
}
