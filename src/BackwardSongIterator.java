//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: BackwardSongIterator.java
///////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the reverse backward direction from a doubly
 * linked list of songs
 * 
 * @author Marin & Cai
 *
 */
public class BackwardSongIterator implements Iterator <Song> {

  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes

  /**
   * Creates a new iterator which iterates through songs in back/tail to front/head order
   * 
   * @param last - reference to the tail of a doubly linked list of songs
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    
    this.next = last;
    
  }

  /**
   * Checks whether there are more songs to return in the reverse order
   * 
   * @return true if there are more songs to return in the reverse order
   */
  @Override
  public boolean hasNext() {

    if (this.next != null) {
      return true;
    }

    return false; // no more song

  }

  /**
   * 
   * @return the next song in the iteration
   * @throws java.util.NoSuchElementException - with a descriptive error message if there are no
   *                                          more songs to return in the reverse order (meaning if
   *                                          this.hasNext() returns false)
   */
  @Override
  public Song next() {

    if(this.hasNext() == false) {
      throw new NoSuchElementException("no more song");
    }
    
    Song nextSong = this.next.getData(); // get the next node
    this.next = this.next.getPrev(); // change the next node
    
    return nextSong;
    
  }

}
