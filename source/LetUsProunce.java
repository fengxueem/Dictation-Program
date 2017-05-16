import java.util.*;

public class LetUsProunce {
  private WordExtractor wordExtractor = new TxtWordExtractor(); 
  private WordRepo wordRepo = new SortedWordRepo();
  
  public void collectWords(String... filePaths) {
  	for (String filePath : filePaths) {
  	  System.out.println("Start reading " + filePath);
  	  for (Word w: wordExtractor.read(filePath)) {
      	wordRepo.put(w);
  	  }
  	}
  }

  public void dictate() {
  	Iterator<Word> it = wordRepo.getIterator();
  	while (it.hasNext()){
  	  System.out.println(it.next());
  	  try {
  	    System.in.read();
  	  } catch(Exception e) {
  	  	e.printStackTrace();
  	  }
  	}
  }

  public static void main(String[] args) {
  	LetUsProunce let = new LetUsProunce();
  	let.collectWords(args);
  	System.out.println("Please type enter when you need to prounce a new word");
  	let.dictate();
  	System.out.println("Congrats!");
  }
}