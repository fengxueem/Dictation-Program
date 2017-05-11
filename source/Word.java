public class Word implements Comparable<Word> {
  private String name;
  private int occurrenceCount;

  public Word(String name) {
  	this.name = name;
  }

  public int compareTo(Word w) {
  	int otherCount = w.getOccurrenceCount();
  	return (occurrenceCount < otherCount ? -1 :
  	 	(occurrenceCount == otherCount ? 0 : 1));
  }
  
  public String getName() {
  	return name;
  }

  public int getOccurrenceCount() {
  	return occurrenceCount;
  }
}