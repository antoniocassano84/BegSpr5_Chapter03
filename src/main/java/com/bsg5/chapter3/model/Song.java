package com.bsg5.chapter3.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Song implements Comparable<Song> {

  private String name;
  private int votes = 0;

  public Song() { }
  public Song(String name) { setName(name); }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int getVotes() { return votes; }
  public void setVotes(int votes) { this.votes = votes; }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(!(obj instanceof Song)) return false;
    Song song = (Song) obj;
    return Objects.equals(getName(), song.getName());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Song.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("votes=" + votes)
            .toString();
  }

  @Override
  public int compareTo(Song o) {
    int value = Integer.compare(o.getVotes(), getVotes());
    if(value == 0) {
      value = getName().compareTo(o.getName());
    }
    return value;
  }
}
