//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: SongPlayerTester.java
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
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method, overridden
   * method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {

    // create Song with invalid input
    try {
      Song song = new Song("Make it right", "BTS", "    ");
      return false; // incorrect
    } catch (java.lang.IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }
    
    // create Song with invalid input
    try {
      Song song = new Song("Make it right", "BTS", null);
      return false; // incorrect
    } catch (java.lang.IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // create Song with invalid input
    try {
      Song song = new Song("Make it right", "BTS", "222");
      return false; // incorrect
    } catch (java.lang.IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }
    
    // create Song with invalid input
    try {
      Song song = new Song("Make it right", "BTS", "60:0");
      return false; // incorrect
    } catch (java.lang.IllegalArgumentException e) {
      // correct
    } catch (Exception e) {
      return false; // incorrect
    }

    // create Song successfully
    // check getter, toString(), equals()
    try {
      Song song = new Song("Make it right", "BTS", "2:22");

      // check getter
      if (!song.getArtist().equals("BTS") || !song.getDuration().equals("2:22")
          || !song.getSongName().equals("Make it right")) {
        return false; // incorrect
      }

      // check toString()
      String expectedRepresentation = "Make it right---BTS---2:22";
      if (!song.toString().equals(expectedRepresentation)) {
        return false; // incorrect
      }

      // check equals()
      Song song1 = new Song("Make it right", "BTS", "22:22");
      if (!song1.equals(song)) {
        return false; // incorrect
      }

    } catch (java.lang.IllegalArgumentException e) {
      return false; // incorrect
    } catch (Exception e) {
      return false; // incorrect
    }

    return true; // passed
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a
   * mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {

    // check constructor and getter
    try {
      Song song1 = new Song("Make it right", "BTS", "22:22");
      LinkedNode<Song> node1 = new LinkedNode<Song>(null, song1, null);

      if (node1.getPrev() != null || node1.getNext() != null || !node1.getData().equals(song1)) {
        return false; // incorrect
      }

      Song song2 = new Song("Chinese song", "Maddie", "9:22");
      LinkedNode<Song> node2 = new LinkedNode<Song>(null, song2, null);
      Song song3 = new Song("Japanese song", "Marin", "11:2");
      LinkedNode<Song> node3 = new LinkedNode<Song>(null, song3, null);

      // check mutator
      node1.setPrev​(node2);
      node1.setNext​(node3);

      if (!node1.getPrev().getData().equals(song2) || !node1.getNext().getData().equals(song3)) {
        return false; // incorrect
      }
      
    } catch (Exception e) {
      return false; // incorrect
    }

    return true; // correct
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {

    try {
      // check addFirst()
      SongPlayer songList = new SongPlayer();
      songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
      if (!songList.getFirst().equals(new Song("Mojito", "Jay Chou", "3:05"))) {
        return false; // incorrect
      }

      // check addLast()
      songList.addLast​(new Song("Mojito1", "Jay Chou1", "3:05"));
      if (!songList.getLast().equals(new Song("Mojito1", "Jay Chou1", "3:05"))) {
        return false; // incorrect
      }

      // check add(int index) method
      songList.add​(1, new Song("Mojito2", "Jay Chou2", "3:05"));
      if (!songList.get​(1).equals(new Song("Mojito2", "Jay Chou2", "3:05"))) {
        return false; // incorrect
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true; // passed
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {

    try {
      // check getFirst()
      SongPlayer songList = new SongPlayer();
      songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
      if (!songList.getFirst().toString().equals("Mojito---Jay Chou---3:05")) {
        return false; // incorrect
      }

      // check getLast()
      songList.addLast​(new Song("Mojito1", "Jay Chou1", "3:05"));
      if (!songList.getLast().toString().equals("Mojito1---Jay Chou1---3:05")) {
        return false; // incorrect
      }

      // check get(int index)
      songList.add​(1, new Song("Mojito2", "Jay Chou2", "3:05"));
      if (!songList.get​(1).toString().equals("Mojito2---Jay Chou2---3:05")) {
        return false; // incorrect
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true; // passed

  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {

    try {

      SongPlayer songList = new SongPlayer();
      songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
      songList.add​(1, new Song("Mojito2", "Jay Chou2", "3:05"));
      songList.addLast​(new Song("Mojito1", "Jay Chou1", "3:05"));
      songList.addLast​(new Song("Mojito11", "Jay Chou11", "3:05"));


      // check removeFirst()
      songList.removeFirst();
      if (!songList.getFirst().equals(new Song("Mojito2", "Jay Chou2", "3:05"))) {
        return false; // incorrect
      }

      // removeLast()
      songList.removeLast();
      if (!songList.getLast().equals(new Song("Mojito1", "Jay Chou1", "3:05"))) {
        return false; // incorrect
      }

      // remove(int index)
      songList.remove​(1);
      if (!songList.get​(0).equals(new Song("Mojito1", "Jay Chou1", "3:05"))) {
        return false; // incorrect
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String
   * play() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    songList.add​(1, new Song("Mojito2", "Jay Chou2", "3:05"));
    songList.addLast​(new Song("Mojito1", "Jay Chou1", "3:05"));
    songList.addLast​(new Song("Mojito11", "Jay Chou11", "3:05"));

    // play
    String output = songList.play();
    String expected = "Mojito---Jay Chou---3:05\n" + "Mojito2---Jay Chou2---3:05\n"
        + "Mojito1---Jay Chou1---3:05\n" + "Mojito11---Jay Chou11---3:05";
    if (!output.equals(expected))
      return false;
    
    // switch direction
    songList.switchPlayingDirection();
    String output2 = songList.play();
    String expected1 = "Mojito11---Jay Chou11---3:05\n" + "Mojito1---Jay Chou1---3:05\n"
        + "Mojito2---Jay Chou2---3:05\n" + "Mojito---Jay Chou---3:05";
    if (!output2.equals(expected1))
      return false;

    return true;
  }

  /**
   * This method checks for the correctness of contains(Object song), clear(), isEmpty()and size()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {

    try {

      SongPlayer songList = new SongPlayer();
      songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
      songList.add​(1, new Song("Mojito2", "Jay Chou2", "3:05"));
      songList.addLast​(new Song("Mojito1", "Jay Chou1", "3:05"));
      songList.addLast​(new Song("Mojito11", "Jay Chou11", "3:05"));

      // contains(Object song) and size()
      if (songList.size() != 4) {
        return false; // incorrect
      }

      if (!songList.contains​(new Song("Mojito", "Jay Chou", "3:05"))) {
        return false; // should contain
      }
      
      songList.remove​(1);
      if(songList.contains​(new Song("Mojito2", "Jay Chou2", "3:05"))) {
        return false; // incorrect
      }

      // clear()
      songList.clear();
      if (songList.size() != 0) {
        return false; // incorrect
      }

      // isEmpty()
      if (songList.isEmpty() == false) {
        return false; // incorrect
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {

    try {

      // first create a chain of (doubly) linked nodes holding at least 3 songs.
      Song song1 = new Song("Make it right", "BTS", "22:22");
      LinkedNode<Song> linkednode1 = new LinkedNode<Song>(null, song1, null);
      
      Song song3 = new Song("Japanese song", "Marin", "11:2");
      LinkedNode<Song> linkednode3 = new LinkedNode<Song>(null, song3, null);

      Song song2 = new Song("Chinese song", "Maddie", "9:22");
      LinkedNode<Song> linkednode2 = new LinkedNode<Song>(linkednode1, song2, linkednode3);

      linkednode1.setNext​(linkednode2);
      //linkednode2.setPrev​(linkednode1); already set prev node 
      //linkednode2.setNext​(linkednode3); already set next node
      linkednode3.setPrev​(linkednode2);

      // create an instance of ForwardSongIterator to iterate through the list of songs starting
      // from its head. Then, check the correctness of both hasNext() and next() methods.
      ForwardSongIterator songList = new ForwardSongIterator(linkednode1);

      // check has next of first node
      if (songList.hasNext() == false) {
        return false; // incorrect
      }

      if (!songList.next().equals(song1)) { // the first node is song1
        return false; // incorrect
      }

      // check has next of second node
      if (songList.hasNext() == false) { // there are the second node
        return false; // incorrect
      }

      if (!songList.next().equals(song2)) {
        return false;
      }

      // check has next of third node
      if (songList.hasNext() == false) { // there are the third node
        return false; // incorrect
      }

      if (!songList.next().equals(song3)) {
        return false;
      }

      // check the next node which is null
      try {

        if (songList.hasNext() == true) {
          return false; // incorrect
        }

        songList.next(); // must throw exception
        return false; // incorrect

      } catch (NoSuchElementException e) {
        // correct
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true;
  }

  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {

    try {

      // first create a chain of (doubly) linked nodes holding at least 3 songs.
      Song song1 = new Song("Make it right", "BTS", "22:22");
      LinkedNode<Song> linkednode1 = new LinkedNode<Song>(null, song1, null);

      Song song3 = new Song("Japanese song", "Marin", "11:2");
      LinkedNode<Song> linkednode3 = new LinkedNode<Song>(null, song3, null);

      Song song2 = new Song("Chinese song", "Maddie", "9:22");
      LinkedNode<Song> linkednode2 = new LinkedNode<Song>(linkednode1, song2, linkednode3);

      linkednode1.setNext​(linkednode2);
      //linkednode2.setPrev​(linkednode1); already set
      //linkednode2.setNext​(linkednode3); already set
      linkednode3.setPrev​(linkednode2);

      // create an instance of BackwardSongIterator to iterate through the list of songs starting
      // from its head. Then, check the correctness of both hasNext() and next() methods.
      BackwardSongIterator songList = new BackwardSongIterator(linkednode3);

      // check has next of first node
      if (songList.hasNext() == false) {
        return false; // incorrect
      }

      if (!songList.next().equals(song3)) {
        return false; // incorrect
      }

      // check has next of second node
      if (songList.hasNext() == false) { // there are the second node
        return false; // incorrect
      }

      if (!songList.next().equals(song2)) {
        return false;
      }

      // check has next of third node
      if (songList.hasNext() == false) { // there are the third node
        return false; // incorrect
      }

      if (!songList.next().equals(song1)) {
        return false;
      }

      // check the next node which is null
      try {

        if (songList.hasNext() == true) {
          return false; // incorrect
        }

        songList.next(); // must throw exception
        return false; // incorrect

      } catch (NoSuchElementException e) {
        // correct
      }

    } catch (Exception e) {
      return false; // incorrect
    }

    return true;

  }
  
  /**
   * additional tester method 
   * 
   * @return true is this test passed
   */
  public static boolean testAdditional() {
    
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addFirst​(new Song("Secret", "Jay Chou", "4:56"));
    songList.addFirst​(new Song("Clear Day", "Jay Chou", "4:59"));
    songList.addFirst​(new Song("Dragon Fist", "Jay Chou", "4:32"));
    songList.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
    songList.addLast​(new Song("StarBoy", "The Weeknd", "3:50"));
    songList.addLast​(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList.add​(1, new Song("Simple Love", "Jay Chou", "4:30"));
    songList.add​(2, new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
    songList.addLast​(new Song("Oh My God", "Adele", "3:45"));
    songList.addLast​(new Song("Levitating", "Dua Lipa", "3:23"));
    songList.add​(6, new Song("Be Kind", "Marshmello & Halsey", "2:53"));
    System.out.println("---------------- Play Forward -----------------");
    System.out.println(songList.play());
    System.out.println("------------------------------------------------");
    System.out.println("songList.remove(6) -- Be Kind -- removed\n"
    + "songList.removeFirst(); -- Out of Time -- removed\n"
    + "songList.removeLast(); -- Levitating -- removed\n");
    songList.remove​(6);
    songList.removeFirst();
    songList.removeLast();
    System.out.println("---------------- Play Forward -----------------");
    System.out.println(songList.play());
    System.out.println("------------------------------------------------");
    Song oneSong = new Song("Mojito", "Jay Chou", "3:05");
    System.out.print("songList.contains(new Song(\"Mojito\", \"Jay Chou\", \"3:05\"): ");
    System.out.println(songList.contains​(oneSong));
    System.out.println();
    System.out.println("songList.size(): " + songList.size());
    System.out.println();
    System.out.print("songList.contains(new Song(\"Be Kind\", \"Marshmello & Halsey\", \"2:53\"): ");
    oneSong = new Song("Be Kind", "Marshmello & Halsey", "2:53");
    System.out.println(songList.contains​(oneSong));
    System.out.println();
    System.out.println("---------------- Play Forward -----------------");
    System.out.println(songList.play());
    System.out.println();
    System.out.println("---------------- Play Backward -----------------");
    songList.switchPlayingDirection();
    System.out.println(songList.play());
    System.out.println("------------------------------------------------");
    
    return true; // passed
    
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {

    return testSong() && testLinkedNode() && testForwardSongIterator() && testBackwardSongIterator()
        && testSongPlayerAdd() && testSongPlayerGet() 
        && testSongPlayerCommonMethod() && testSongPlayerIterator();

  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {

    System.out.println(runAllTests());

  }
}
