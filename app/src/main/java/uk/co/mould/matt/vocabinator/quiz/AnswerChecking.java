package uk.co.mould.matt.vocabinator.quiz;

public interface AnswerChecking {

    void check(String questionWord, String answer, Callback callback);

    interface Callback {
        void correct();
        void incorrect();
    }
}
