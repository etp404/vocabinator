package uk.co.mould.matt.vocabinator.quiz;

import uk.co.mould.matt.vocabinator.Question;
import uk.co.mould.matt.vocabinator.RandomNumberGenerator;
import uk.co.mould.matt.vocabinator.VocabItem;
import uk.co.mould.matt.vocabinator.VocabStorage;

public class RandomQuestionGenerator implements QuestionGenerator {
    private final RandomNumberGenerator randomNumberGenerator;
    private final VocabStorage vocabStorage;

    public RandomQuestionGenerator(RandomNumberGenerator randomNumberGenerator, VocabStorage vocabStorage) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.vocabStorage = vocabStorage;
    }

    @Override
    public void getQuestion(Callback callback) {
        VocabItem vocabItem = vocabStorage.getVocabItems().get(randomNumberGenerator.randomNumber(0, 0));
        callback.questionProvided(new Question(vocabItem.englishWord, vocabItem.frenchWord));
    }
}
