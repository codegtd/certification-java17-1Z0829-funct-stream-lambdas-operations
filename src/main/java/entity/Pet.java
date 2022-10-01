package entity;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    int[] random =
         new Random()
              .ints(0, 8)
              .limit(6)
              .toArray();

    // Populate Pet with randomly selected data
    int i = 0;
    this.name = namesArray[random[i++]];
    this.type = typesArray[random[i++]];
    this.state = statesArray[random[i++]];
    this.owner = ownerArray[random[i++]];
    this.vet = vetArray[random[i++]];
    this.age = random[i++];
  }

  public String toString() {
    return "\nPet{" +
         "name='" + name + '\'' +
         ", type='" + type + '\'' +
//         ", owner='" + owner + '\'' +
         ", vet='" + vet + '\'' +
         ", state='" + state + '\'' +
//         ", age=" + age +
         '}';
  }

  public static List<Pet> getPets() {

    List<Pet> petPopulation = Stream.generate(Pet::new)
                                    .limit(100)
                                    .collect(Collectors.toList());
    return petPopulation;
  }
}