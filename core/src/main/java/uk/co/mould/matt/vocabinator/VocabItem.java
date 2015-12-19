package uk.co.mould.matt.vocabinator;

class VocabItem {
    public final String englishWord;
    public final String frenchWord;

    public VocabItem(String englishWord, String frenchWord) {
        this.englishWord = englishWord;
        this.frenchWord = frenchWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VocabItem vocabItem = (VocabItem) o;

        if (englishWord != null ? !englishWord.equals(vocabItem.englishWord) : vocabItem.englishWord != null)
            return false;
        return !(frenchWord != null ? !frenchWord.equals(vocabItem.frenchWord) : vocabItem.frenchWord != null);

    }

    @Override
    public int hashCode() {
        int result = englishWord != null ? englishWord.hashCode() : 0;
        result = 31 * result + (frenchWord != null ? frenchWord.hashCode() : 0);
        return result;
    }
}
