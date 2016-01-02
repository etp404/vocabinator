package uk.co.mould.matt.vocabinator.quiz;

public interface QuestionGenerator {
    void getQuestion(Callback callback);

    interface Callback {
        void questionProvided(String questionWord);
    }
}

