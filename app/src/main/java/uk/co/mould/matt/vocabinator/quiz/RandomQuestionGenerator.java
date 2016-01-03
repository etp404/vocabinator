package uk.co.mould.matt.vocabinator.quiz;

import java.util.List;

import uk.co.mould.matt.vocabinator.Question;
import uk.co.mould.matt.vocabinator.RandomNumberGenerator;
import uk.co.mould.matt.vocabinator.VocabItem;
import uk.co.mould.matt.vocabinator.VocabStorage;

public class RandomQuestionGenerator implements QuestionGenerator {
    private final RandomNumberGenerator randomNumberGenerator;
    private final VocabStorage vocabStorage;

    public RandomQuestionGenerator(VocabStorage vocabStorage, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.vocabStorage = vocabStorage;
    }

    @Override
    public void getQuestion(Callback callback) {
        List<VocabItem> vocabItems = vocabStorage.getVocabItems();
        VocabItem vocabItem = vocabItems.get(randomNumberGenerator.randomNumber(0, vocabItems.size()));
        callback.questionProvided(new Question(vocabItem.englishWord, vocabItem.frenchWord));
    }
}
