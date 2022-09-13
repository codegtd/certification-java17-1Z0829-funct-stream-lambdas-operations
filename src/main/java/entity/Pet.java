package entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
public class Pet {

  // Set up test data for grouping tests
  private String[] namesArray = {"Spot", "Bob", "Barkley",
       "Charlie", "Fluffy", "Boots", "Angel", "Mittens"};

  private String[] statesArray =
       {"AL", "CO", "DE", "PA", "FL", "GA", "NJ", "NY"};

  private String[] typesArray = {"Dog", "Cat", "Hamster", "Fish",
       "Chinchilla", "Ferret", "Gerbil", "Pig"};

  private String[] ownerArray = {"Allen", "Bob", "Caleb", "Don",
       "Greg", "Howard", "Ira", "James"};

  private String[] vetArray = {"Bucks", "Pipersville", "Newtown",
       "New Hope", "Chalfont", "Ambler", "Lambertville", "Dublin"};

  @Getter private String name;
  @Getter private String type;
  @Getter private String owner;
  @Getter private String vet;
  @Getter private String state;
  @Getter private int age;

  public Pet() {
    // Use streaming skills to get 6 random #'s between 0 & 7
    int[] randoms =
         new Random()
              .ints(0, 8)
              .limit(6)
              .toArray();

    // Populate Pet with randomly selected data
    int i = 0;
    this.name = namesArray[randoms[i++]];
    this.type = typesArray[randoms[i++]];
    this.state = statesArray[randoms[i++]];
    this.owner = ownerArray[randoms[i++]];
    this.vet = vetArray[randoms[i++]];
    this.age = randoms[i++];
  }
}