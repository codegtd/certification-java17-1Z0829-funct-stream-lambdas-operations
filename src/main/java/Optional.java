import entity.CollegeStudent;

import java.util.List;

public class Optional {
  public static void main(String[] args) {

    CollegeStudent joe = new CollegeStudent("Joe", 3.2f);
    CollegeStudent jane = new CollegeStudent("Jane");

    //    List.of(joe, jane)
    //        .stream()
    //        .forEach(OptionalTests::printStatus);

    List.of(joe, jane)
        .stream()
//        .filter(s -> s.getGpa().isPresent())
        .filter(s -> !s.getGpa().isEmpty())
        .forEach(s -> System.out.println(
             s.getName() +
                  (s.getGpa()
                    .get() >= 2.0f
                       ? " in good standing" :
                       " on academic probation")));

  }

  // Print's student's academic status
  private static void printStatus(CollegeStudent student) {

    System.out.print(student.getName());
    java.util.Optional<Float> gpa;
    if ((gpa = student.getGpa()).isPresent()) {
      if (gpa.get() < 2.0) {
        System.out.println(" is on academic probation");
      } else {
        System.out.println(" is in good standing");
      }
    } else System.out.println(" has an unknown gpa");
  }
}