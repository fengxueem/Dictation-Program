package util;

import java.util.Iterator;

public interface WordRepo {
  void put(Word w);
  boolean remove(Word w);
  Word get(String wordName);
  Word getFirst();
  Iterator<Word> getIterator();
  int getSize();
  String getRepoName();
  void setRepoName(String repoName);
}