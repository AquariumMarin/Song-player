//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ForwardSongIterator.java
// Course: CS 300 Spring 2022
//
// Author: Marin Suzuki
// Email: msuzuki9@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Xingzhen Cai
// Partner Email: xcai79@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the forward direction from a doubly linked list
 * of songs
 * 
 * @author Marin Suzuki Xingzhen cai
 */
public class ForwardSongIterator implements Iterator<Song> {

  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes.

  /**
   * Creates a new iterator which iterates through songs in front/head to back/tail order
   * 
   * @param first - reference to the head of a doubly linked list of songs
   */
  public ForwardSongIterator(LinkedNode<Song> first) {

    this.next = first;

  }

  /**
   * Checks whether there are more songs to return
   * 
   * @return true if there are more songs to return
   */
  @Override
  public boolean hasNext() {
    if (this.next != null) {
      return true;
    }

    return false; // no next song

  }

  /**
   * Returns the next song in the iteration
   * 
   * @return the next song in the iteration
   * @throws java.util.NoSuchElementException - with a descriptive error message if there are no
   *                                          more songs to return in the reverse order (meaning if
   *                                          this.hasNext() returns false)
   * 
   */
  @Override
  public Song next() {
    
    if(!this.hasNext()) {
      throw new java.util.NoSuchElementException("No more song");
    }else {
      
      Song nextSong = this.next.getData(); // get the next node
      this.next = this.next.getNext(); // change next node
      
      return nextSong;
    }
    
  }

}
