package entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.Random;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class PetTim {

  @Getter(AccessLevel.NONE)    @ToString.Exclude
  private String[] names = {"Spot", "Bob", "Bark", "Char", "Fluf", "Boots", "Angel", "Mit"};
  @Getter(AccessLevel.NONE)    @ToString.Exclude
  private String[] states = {"AL", "CO", "DE", "PA", "FL", "GA", "NJ", "NY"};
  @Getter(AccessLevel.NONE)    @ToString.Exclude
  private String[] types = {"Dog", "Cat", "Hamster", "Fish", "Chinch", "Ferret", "Gerb", "Pig"};
  @Getter(AccessLevel.NONE)    @ToString.Exclude
  private String[] owners = {"All", "Bob", "Cal", "Don", "Greg", "How", "Ira", "Jam"};
  @Getter(AccessLevel.NONE)    @ToString.Exclude
  private String[] vets = {"Buc", "Piper", "Newtown", "New", "Chal", "Amb", "Lamb", "Dub"};

  @EqualsAndHashCode.Include
  private String name;

  @EqualsAndHashCode.Include
  private String type;
  private String owner;
  private String vet;
  private String state;
  private int age;

  public PetTim() {
    // Use streaming skills to get 6 random #'s between 0 & 7
    int[] randoms = new Random().ints(0, 8)
                                .limit(6)
                                .toArray();

    // Populate Pet with randomly selected data
    int i = 0;
    this.name = names[randoms[i++]];
    this.type = types[randoms[i++]];
    this.state = states[randoms[i++]];
    this.owner = owners[randoms[i++]];
    this.vet = vets[randoms[i++]];
    this.age = randoms[i++];
  }

//    public boolean equals(Object o) {
//      if (this == o) return true;
//      if (! (o instanceof PetTim)) return false;
//      PetTim pet = (PetTim) o;
//      return getName().equals(pet.getName()) &&
//             getType().equals(pet.getType());
//    }

}