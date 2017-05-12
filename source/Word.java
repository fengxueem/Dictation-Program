import java.util.concurrent.locks.*;

public class Word implements Comparable<Word> {
  private final String name;
  private int occurrenceCount;
  private Lock lock = new ReentrantLock();

  // every time a new word comes, it's counted 1
  public Word(String name) {
  	this.name = name;
  	this.occurrenceCount = 1;
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
  	lock.lock();
  	try {
  	  return occurrenceCount;
  	} finally {
  	  lock.unlock();
  	}
  }

  public void addCount(int count) {
  	lock.lock();
  	try {
  	  occurrenceCount += count;
  	} finally {
  	  lock.unlock();
  	}
  }
}