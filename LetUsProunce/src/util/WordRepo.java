package util;

import java.util.Iterator;

public interface WordRepo {
  void put(Word w);
  boolean remove(Word w);
  Word get(String wordName);
  Iterator<Word> getIterator();
}