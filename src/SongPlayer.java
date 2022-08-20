//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: SongPalyer.java
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterable collection of songs. Songs can be played in the forward or reverse
 * order.
 * 
 * @author Marin & Cai
 *
 */
public class SongPlayer implements Iterable<Song> {

  private int size; // size of the list
  private LinkedNode<Song> head; // head of this doubly linked list
  private LinkedNode<Song> tail; // tail of this doubly linked list
  private boolean playingBackward; // true if this song player is reading the list backward

  /**
   * Creates a new instance of song player which contains zero songs and set by default to play
   * songs in the forward direction. [Implementing this constructor is optional since it will be
   * added by default by the compiler]
   */
  public SongPlayer() {

  }

  /**
   * add Song as First Song
   * 
   * @param oneSong - the song that is going to be added to the head of this doubly linked list of
   *                songs
   * @throws java.lang.NullPointerException - with a descriptive error message if the passed oneSong
   *                                        is null
   */
  public void addFirst​(Song oneSong) throws java.lang.NullPointerException {

    if (oneSong == null) {
      throw new NullPointerException("input song is null");
    }

    // if list is empty
    if (this.size == 0) {

      // create new node having null previous and null next node
      LinkedNode<Song> newSong = new LinkedNode(null, oneSong, null);

      this.head = newSong; // set the head to newSong
      this.tail = newSong; // set the tail to newSong
      this.size = this.size + 1; // size increased
    } else {

      // if the list is not empty

      // create new node having null as its previous node and original head as its next node
      LinkedNode<Song> newSong = new LinkedNode(null, oneSong, this.head);

      this.head.setPrev​(newSong); // set the previous node of the original first node
      this.head = newSong; // set the head to newSong
      this.head.setNext​(newSong);
      this.size = this.size + 1; // size increased

    }

  }

  /**
   * Adds a Song as Last Song
   * 
   * @param oneSong - the song that is going to be added to the tail of this doubly linked list of
   *                songs
   */
  public void addLast​(Song oneSong) {

    // when the original list is empty
    if (this.size == 0) {

      // create new node having null previous and null next node
      LinkedNode<Song> newSong = new LinkedNode(null, oneSong, null);

      this.head = newSong; // set the head to newSong
      this.tail = newSong; // set the tail to newSong
      this.size = this.size + 1; // size increased

    }

    // when the original list is not null
    else {

      // create new node having the original tail as its previous node and null as its next node
      LinkedNode<Song> newSong = new LinkedNode(this.tail, oneSong, null);

      this.tail.setNext​(newSong); // change the next node of the original end node
      this.tail = newSong; // set the tail to newSong
      this.size = this.size + 1; // size increased

    }

  }

  /**
   * adds Song at a given position/order within this collection of songs
   * 
   * @param index   - the given index where the new song will be added
   * @param oneSong - the song that is going to be added
   * @throws java.lang.NullPointerException      - with a descriptive error message if the passed
   *                                             oneSong is null
   * @throws java.lang.IndexOutOfBoundsException - with a descriptive error message if index is out
   *                                             of the 0 .. size() range
   */
  public void add​(int index, Song oneSong) {

    if (oneSong == null) {
      throw new java.lang.NullPointerException("input song is null");
    }

    if (index < 0 || index > this.size) {
      throw new java.lang.IndexOutOfBoundsException("index is invalid");
    }

    // when index is 0
    if (index == 0) {
      this.addFirst​(oneSong);
    }

    // when index is size
    else if (index == this.size) {
      this.addLast​(oneSong);
    } else {

      // when index is neither 0 nor size()

      // looking for the reference to the previous node (node at the index - 1)
      LinkedNode<Song> previousNode = this.head;

      for (int i = 1; i <= index - 1; i++) {
        previousNode = previousNode.getNext(); // get reference for the node at the index - 1
      }

      // looking for the reference to the next node (node at the index)
      LinkedNode<Song> nextNode = previousNode.getNext(); // node at the index

      // create new node having previousNode as its previous node and nextNode as its next node
      LinkedNode<Song> newSong = new LinkedNode(previousNode, oneSong, nextNode);

      // change the reference for the next node of previousNode to newSong
      previousNode.setNext​(newSong);

      // change the reference for the previous node of nextNode to newSong
      nextNode.setPrev​(newSong);

      // size changed
      this.size = this.size + 1;

    }

  }

  /**
   * Returns the first Song in this list.
   * 
   * @return the Song at the head of this list
   * @throws java.util.NoSuchElementException - with a descriptive error message if this list is
   *                                          empty
   */
  public Song getFirst() throws java.util.NoSuchElementException {

    if (this.size == 0) {
      throw new java.util.NoSuchElementException("list is empty");
    }
    return head.getData();

  }

  /**
   * Returns the last Song in this list.
   * 
   * @return the Song at the tail of this list
   * @throws java.util.NoSuchElementException - with a descriptive error message if this list is
   *                                          empty
   */
  public Song getLast() throws java.util.NoSuchElementException {

    if (this.size == 0) {
      throw new java.util.NoSuchElementException("list is empty");
    }

    return this.tail.getData();

  }

  /**
   * Returns the song at the specified position in this list.
   * 
   * @param index - index of the song to return
   * @return the song at the specified position in this list
   * @throws java.lang.IndexOutOfBoundsException - with a descriptive error message if index is out
   *                                             of the 0 .. size()-1 range
   */
  public Song get​(int index) throws java.lang.IndexOutOfBoundsException {

    if (index < 0 || index >= this.size) {
      throw new java.lang.IndexOutOfBoundsException("index is invalid");
    }

    LinkedNode<Song> idealNode = this.head;
    for (int i = 1; i <= index; i++) {
      idealNode = idealNode.getNext(); // get reference for the node at the index
    }

    return idealNode.getData();

  }

  /**
   * Removes and returns the first song from this list.
   * 
   * @return the first song from this list
   * @throws java.util.NoSuchElementException - with a descriptive error message if this list is
   *                                          empty
   */
  public Song removeFirst() throws java.util.NoSuchElementException {

    if (this.size == 0) {
      throw new java.util.NoSuchElementException("list is empty");
    } else if (this.size == 1) {

      this.size = 0; // 1 - 1 = 0

      Song originalHeadNode = this.head.getData();

      this.head = null; // head should be null
      this.tail = null; // tail should be null

      return originalHeadNode;

    } else {

      // get the node in the index of 1
      LinkedNode<Song> idealNode = head.getNext();

      // node in the index of 1 has null as its previous node
      idealNode.setPrev​(null);

      // get the original head node
      Song originalHeadNode = this.head.getData();

      // set the head with node in the index of 1
      this.head = idealNode;

      // size changed
      this.size = this.size - 1;

      return originalHeadNode;

    }

  }

  /**
   * Removes and returns the last song from this list.
   * 
   * @return the last song from this list
   * @throws java.util.NoSuchElementException - with a descriptive error message if this list is
   *                                          empty
   */
  public Song removeLast() {

    if (this.size == 0) {
      throw new java.util.NoSuchElementException("list is empty");
    } else if (this.size == 1) {

      this.size = 0; // 1 - 1 = 0

      Song originalTailNode = this.tail.getData();

      this.head = null; // head should be null
      this.tail = null; // tail should be null

      return originalTailNode;

    } else {

      // get the original tail node
      Song originalTailNode = this.tail.getData();

      this.tail = this.tail.getPrev(); // set the new tail
      this.tail.setNext​(null); // node in the second last index has null its next node

      // size changed
      this.size = this.size - 1;

      return originalTailNode;
    }

  }

  /**
   * Removes the song at the specified position in this list and returns the song that was removed
   * from the list. The order of precedence of the other songs in the list should not be modified.
   *
   * @param index - the index of the song to be removed
   * @return the song previously at the specified position
   * @throws java.lang.IndexOutOfBoundsException - with a descriptive error message if index is out
   *                                             of the 0 .. size()-1 range
   */
  public Song remove​(int index) throws java.lang.IndexOutOfBoundsException {

    if (index < 0 || index >= this.size) {
      throw new java.lang.IndexOutOfBoundsException("index is invalid");
    }

    else if (index == 0) {
      this.removeFirst();
    }

    else if (index == this.size - 1) {
      this.removeLast();
    } else {

      // looking for the reference to the previous node (node at the index - 1)
      LinkedNode<Song> previousNode = this.head;

      for (int i = 1; i <= index - 1; i++) {
        previousNode = previousNode.getNext(); // get reference for the node at the index - 1
      }

      LinkedNode<Song> nodeInIndex = previousNode.getNext();

      // looking for the reference to the new next node (node at the index + 1)
      LinkedNode<Song> nextNode = previousNode.getNext().getNext(); // node at the index + 1

      previousNode.setNext​(nextNode); // remove the node in the index
      nextNode.setPrev​(previousNode); // set the new previous node

      this.size = this.size - 1; // size changed

      return nodeInIndex.getData();
    }

    return null; // default

  }

  /**
   * Returns true if this list contains a match with the specified song. More formally, returns true
   * if and only if this list contains at least one song e such that Objects.equals(o, e).
   * 
   * @param o - song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains​(Song o) {

    LinkedNode<Song> currentNode = this.head;

    while (currentNode != null) { // loop until tail
      if (currentNode.getData().equals(o)) { // matched found
        return true;
      }
      currentNode = currentNode.getNext();
    }

    return false; // no matched

  }

  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {

    // set the head
    this.head = null;

    // set the tail
    this.tail = null;

    // size became 0
    this.size = 0;

  }

  /**
   * Returns true if this list is empty.
   * 
   * @return true if this list is empty
   */
  public boolean isEmpty() {
    if (this.size == 0) {
      return true;
    }

    return false;
  }

  /**
   * Returns the number of songs in this list.
   * 
   * @return the number of songs in this list
   */
  public int size() {

    return this.size;

  }

  /**
   * Returns an iterator to iterate through the songs in this list with respect to current playing
   * direction of this song player (either in the forward or in the backward direction)
   * 
   * @return an Iterator to traverse the list of songs in this SongPlayer with respect to the
   *         current playing direction specified by the playingBackward data field.
   */
  public java.util.Iterator<Song> iterator() { //TODO

    if (this.playingBackward == true) { // backward

      return (Iterator<Song>) (new BackwardSongIterator(tail));

    } else { // forward

      return (Iterator<Song>) (new ForwardSongIterator(head));

    }

  }

  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction by
   * setting playingBackward to its opposite value.
   */
  public void switchPlayingDirection() {

    if (this.playingBackward == true) {
      this.playingBackward = false; // change direction
    }

    else if (this.playingBackward == false) {
      this.playingBackward = true;
    }

  }

  /**
   * Plays the songs in this song player in the current playing direction. This method MUST be
   * implemented using an enhanced for-each loop.
   * 
   * @return a String representation of the songs in this song player. String representations of
   *         each song are separated by a newline. If this song player is empty, this method returns
   *         an empty string.
   */
  public java.lang.String play() {

    String allSongRepresentation = "";

    for (Song song : this) {
      allSongRepresentation += song.toString() + "\n";
    }

    return allSongRepresentation.trim();

  }

}
