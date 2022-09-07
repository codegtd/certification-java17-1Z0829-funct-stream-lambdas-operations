package entity;

import lombok.*;

import java.util.Optional;

@RequiredArgsConstructor
public class CollegeStudent {

  @NonNull
  @Getter
  private String name;

  private Optional<Float> gpa = Optional.empty();


  public CollegeStudent(String name, float gpa) {
    this.name = name;
    this.gpa = Optional.of(gpa);
  }

  public Optional<Float> getGpa() {

    return gpa;
  }

  public void setGpa(Float gpa) {

    this.gpa = Optional.ofNullable(gpa);
  }
}