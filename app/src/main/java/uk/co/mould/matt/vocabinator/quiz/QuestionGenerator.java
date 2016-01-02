package uk.co.mould.matt.vocabinator.quiz;

import uk.co.mould.matt.vocabinator.Question;

public interface QuestionGenerator {
    void getQuestion(Callback callback);

    interface Callback {
        void questionProvided(Question question);
    }
}

