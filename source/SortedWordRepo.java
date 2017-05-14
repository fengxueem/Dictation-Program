import java.util.*;

public class SortedWordRepo implements WordRepo {
  private LinkedList<Word> allWords = new LinkedList<Word>();

  public void put(Word w) {
  	Word temp = get(w.getName());
  	if (temp != null) {
  	  temp.addCount(1);
  	  remove(temp);
  	  w = temp;
  	}
  	allWords.add(w);
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
  public String toString() {
  	return allWords.toString();
  }
  public void sort() {
  	Collections.sort(allWords);
  }

  public static void main(String[] args) {
  	TxtWordExtractor txt = new TxtWordExtractor();
  	SortedWordRepo repo = new SortedWordRepo();
  	for (Word w: txt.read("../text.txt")) {
      System.out.println(w);
	  repo.put(w);
  	  System.out.println(repo);
  	}
  	repo.sort();
  	System.out.println(repo);
  }
}