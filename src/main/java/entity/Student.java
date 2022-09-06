package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@ToString
public class Student {

  private String[] namesArray = {
       "Allen", "Bob", "Caleb", "Don", "Fred",
       "Greg", "Howard", "Ira", "James", "Kevin"};
  private static int lastId = 1000;

  @Getter
  @Setter
  private String name;

  @Getter
  private int studentId;

  // Assigns a name at random and studentId
  {
    int i = new Random().nextInt(10);
    this.name = namesArray[i];
    // Generate new id for new student
    this.studentId = ++ lastId;
  }
}