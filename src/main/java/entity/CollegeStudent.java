package entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CollegeStudent {

  @NonNull
  @Getter
  private String name;

  private Optional<Float> gpa = Optional.empty();
  //  private Float gpa;


  public CollegeStudent(String name, float gpa) {

    this.name = name;
    //    this.gpa = gpa;
    this.gpa = Optional.of(gpa);
  }

  public Optional<Float> getGpa() {
    //  public Float getGpa() {

    return gpa;
  }

  public void setGpa(Float gpa) {

    //    this.gpa = gpa;
    this.gpa = Optional.ofNullable(gpa);
  }
}