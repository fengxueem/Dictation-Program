import java.util.*;

public class SortedWordRepo implements WordRepo {
  private TreeSet<Word> allWords = new TreeSet<Word>();

  public void put(Word w) {
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
  
  public static void main(String[] args) {
  	TxtWordExtractor txt = new TxtWordExtractor();
  	SortedWordRepo repo = new SortedWordRepo();
  	for (Word w: txt.read("../text.txt")) {
	  repo.put(w);  		
  	}
  	System.out.println(repo);
  }
}