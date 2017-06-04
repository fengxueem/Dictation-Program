package util;

import java.util.concurrent.locks.*;

public class Word implements Comparable<Word> {
  private final String name;
  private int occurrenceCount;
  private Lock lock = new ReentrantLock();

  // every time a new word comes, it's counted 1
  public Word(String name) {
    this(name,1);
  }
  // add one more constructor for flexibility
  public Word(String name, int occurrenceCount) {
  	this.name = name;
  	this.occurrenceCount = occurrenceCount;
  }

  public int compareTo(Word w) {
  	int otherCount = w.getOccurrenceCount();
  	return (occurrenceCount < otherCount ? 1 :
  	 	(occurrenceCount == otherCount ? 0 : -1));
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

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Word && name.equals(((Word)obj).getName());
  }

  @Override
  public String toString() {
    return name + " : " + getOccurrenceCount();
  }
}