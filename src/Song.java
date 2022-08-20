//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Song.java
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
 * This class maintains the song name, artist, and duration
 * 
 * @author Marin & Cai
 *
 */
public class Song {

  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song

  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song
   * 
   * @param songName title of the song
   * @param artist   name of the artist who performed this song
   * @param duration duration of the song in the format mm:ss
   * @throws java.lang.IllegalArgumentException with a descriptive error message if either of
   *                                            songName, or artist, or duration is null or is
   *                                            blank, or if the duration is not formatted as mm:ss
   *                                            where both mm and ss are in the 0 .. 59 range.
   */
  public Song(java.lang.String songName, java.lang.String artist, java.lang.String duration)
      throws java.lang.IllegalArgumentException {

    // songName, or artist, or duration is null or is blank
    if (songName == null || artist == null || duration == null || songName.isBlank()
        || artist.isBlank() || duration.isBlank()) {
      throw new java.lang.IllegalArgumentException("input is invalid");
    }

    // duration is not formatted as mm:ss where both mm and ss are in the 0 .. 59 range.
    // when mm has length of 2
    if (duration.substring(2, 3).equals(":")) {
      try {
        if (Integer.parseInt(duration.substring(0, 2)) > 59
            || Integer.parseInt(duration.substring(0, 2)) < 0
            || Integer.parseInt(duration.substring(3)) > 59
            || Integer.parseInt(duration.substring(3)) < 0
            || !duration.substring(2, 3).equals(":")) {
          throw new java.lang.IllegalArgumentException("input is invalid");
        }
      } catch (NumberFormatException e) { // mm or ss cannot change to int
        throw new java.lang.IllegalArgumentException("input is invalid");
      }
    }

    // when mm has length of 1
    if (!duration.substring(2, 3).equals(":")) {
      try {
        if (Integer.parseInt(duration.substring(0, 1)) > 59
            || Integer.parseInt(duration.substring(0, 1)) < 0
            || Integer.parseInt(duration.substring(2)) > 59
            || Integer.parseInt(duration.substring(2)) < 0
            || !duration.substring(1, 2).equals(":")) {
          throw new java.lang.IllegalArgumentException("input is invalid");
        }
      } catch (NumberFormatException e) { // mm or ss cannot change to int
        throw new java.lang.IllegalArgumentException("input is invalid");
      }
    }

    this.songName = songName;
    this.artist = artist;
    this.duration = duration;

  }

  /**
   * Gets the title or name of this song
   * 
   * @return the title or name of this song
   */
  public java.lang.String getSongName() {
    return this.songName;
  }

  /**
   * Gets the name of the artist who performed this song
   * 
   * @return the artist who performed this song
   */
  public java.lang.String getArtist() {
    return this.artist;
  }

  /**
   * Gets the duration of this song
   * 
   * @return the duration
   */
  public java.lang.String getDuration() {
    return this.duration;
  }

  /**
   * Returns a string representation of this song. This string should be formatted as follows.
   * "songName---artist---duration" where songName is the title of the song, artist is the name of
   * the artist, and duration is the duration of the song.
   * 
   * @return a string representation of this song.
   */
  @Override
  public java.lang.String toString() {

    return "" + this.songName + "---" + this.artist + "---" + this.duration;

  }

  /**
   * Returns true when this song's name and artist strings equals to the other song's name and
   * artist strings, and false otherwise. Note that this method takes an Object rather than a Song
   * argument, so that it Overrides Object.equals(Object). If an object that is not an instance of
   * Song is ever passed to this method, it should return false.
   * 
   * @param other - Song object to compare this object to
   * @return true when the this song has matching name and artist with respect to another song (case
   *         insensitive comparison)
   */
  @Override
  public boolean equals(Object other) {

    if (other instanceof Song) { // check if the object is an instance of Song
      if (this.songName.equalsIgnoreCase(((Song) other).getSongName())
          && this.artist.equalsIgnoreCase(((Song) other).getArtist())) {
        return true; // matched song name and artist
      } else {
        return false; // not matched
      }
    } else {
      return false; // not instance of Song
    }
  }

}
