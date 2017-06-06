package util;

import java.util.*;

public class SortedWordRepo implements WordRepo {
  private LinkedList<Word> allWords = new LinkedList<Word>();
  private String repoName;
  
  public SortedWordRepo() {}
  public SortedWordRepo(String repoName) {
	this.repoName = repoName;
  }
  
  public void put(Word w) {
  	Word temp = get(w.getName());
  	if (temp != null) {
      // if w is an existed word, then update its occurrenceCount
  	  temp.addCount(w.getOccurrenceCount());
  	} else {
      // if w is a new word, just add
      allWords.add(w);
    }
    sort();
  }
  public boolean remove(Word w) {
  	return allWords.remove(w);
  }
  public Word get(String wordName) {
  	for (Word w : allWords) {
  	  if (w.getName().equals(wordName)) {
  	  	return w;
  	  }
  	}
  	return null;
  }
  public Iterator<Word> getIterator() {
    return allWords.iterator();
  }
  public String toString() {
  	return allWords.toString();
  }
  private void sort() {
  	Collections.sort(allWords);
  }
  public int getSize() {
	return allWords.size();
  }
  public String getRepoName() {
	return repoName;
  }
  public void setRepoName(String repoName) {
	this.repoName = repoName;
  }
  
  
  // test method
  public static void main(String[] args) {
  	TxtWordExtractor txt = new TxtWordExtractor();
  	SortedWordRepo repo = new SortedWordRepo();
  	for (Word w: txt.read("../text.txt")) {
      System.out.println(w);
      repo.put(w);
  	  System.out.println(repo);
  	}
  	System.out.println(repo);
  }
}