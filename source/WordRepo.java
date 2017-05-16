import java.util.Iterator;

interface WordRepo {
  void put(Word w);
  boolean remove(Word w);
  Word get(String wordName);
  Iterator<Word> getIterator();
}