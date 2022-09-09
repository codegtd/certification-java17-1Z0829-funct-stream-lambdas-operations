import entity.CollegeStudent;

import java.util.List;
import java.util.Optional;

public class Optional_basic {
  public static void main(String[] args) {

    CollegeStudent joe = new CollegeStudent("Joe", 3.2f);
    CollegeStudent jane = new CollegeStudent("Jane");

    //    testsOfExceptions(joe, jane);
    //    testsSimpleOptionalMethods(joe, jane);
    //    OptionalMethodOr(joe, jane);
    //    OptionOrElseReturnMethod(joe, jane);
    //    OptionOrElseReturnValue(joe, jane);
    //    OptionOrElseThrowMethod(joe, jane);
    OptionOrElseGetMethod(joe, jane);
  }

  private static void OptionOrElseGetMethod(CollegeStudent joe, CollegeStudent jane) {

    List.of(joe, jane)
        .stream()
        .forEach(student -> show(
             student.getName() +
                  (student.getGpa()
                          .orElseGet(Optional_basic::getGpaEstimate)
                       >= 2.0f ? " good-stand" : " acad-prob")));

    showGpas(joe, jane);
  }

  private static void OptionOrElseThrowMethod(CollegeStudent joe, CollegeStudent jane) {

    List.of(joe, jane)
        .stream()
        .forEach(student -> show(
             student.getName() +
                  (student.getGpa()
                          .orElseThrow()
                       >= 2.0f ? " good-stand" : " acad-prob")));

    showGpas(joe, jane);
  }

  private static void OptionOrElseReturnValue(CollegeStudent joe, CollegeStudent jane) {

    List.of(joe, jane)
        .stream()
        .forEach(student -> show(
             student.getName() +
                  (student.getGpa()
                          .orElse(2.0f)
                       >= 2.0f ? " good-stand" : " acad-prob")));

    showGpas(joe, jane);
  }

  private static void OptionOrElseReturnMethod(CollegeStudent joe, CollegeStudent jane) {
    // Execute method regardless the Optiona-Source is null, meaning
    // Execute the method if the Optionla-Source is "Null" or "Not-Null"
    List.of(joe, jane)
        .stream()
        .forEach(student -> show(
             student.getName() +
                  (student.getGpa()
                          .orElse(getGpaEstimate())
                       >= 2.0f ? " good-stand" : " acad-prob")));

    showGpas(joe, jane);
  }

  private static void OptionalMethodOr(CollegeStudent joe, CollegeStudent jane) {

    List.of(joe, jane)
        .stream()
        .forEach(s -> show(
             s.getName() + (s.getGpa()
                             // .or(() -> Optional.of(2.0f))
                             .or(() -> {
                               show("Supplier for: " + s.getName());
                               return Optional.of(2.0f);
                             })
                             .get() >= 2.0f ? " good-stand" : " acad-prob")));

    showGpas(joe, jane);
  }

  private static void showGpas(CollegeStudent joe, CollegeStudent jane) {

    System.out.println("\n");
    show("Joe's gpa = " + joe.getGpa());
    show("Jane's gpa = " + jane.getGpa());
  }

  private static void basicOptionalMethods(CollegeStudent joe, CollegeStudent jane) {

    List.of(joe, jane)
        .stream()
        .filter(student -> student.getGpa()
                                  .isPresent())
        // .filter(s -> ! s.getGpa().isEmpty())
        .forEach(filteredStudent -> System.out.println(
             filteredStudent.getName() + (filteredStudent.getGpa()
                                                         .get() >= 2.0f ? " in good standing" :
                  " on academic probation")));
  }

  private static void show(String text) {

    System.out.println(text);
  }

  private static float getGpaEstimate() {

    System.out.println("-> getGpaEst-method");
    return 2.0f;
  }

  //  private static void testsOfExceptions(CollegeStudent joe, CollegeStudent jane) {
  //
  //    List.of(joe, jane)
  //        .stream()
  //        //        .forEach(Optional::printStatus);
  //        .forEach(collegeStudent -> {
  //              show(collegeStudent.getName());
  //              if (collegeStudent.getGpa() < 2.0) {
  //                show(" is on academic probation");
  //              } else {
  //                show(" is in good standing");
  //              }
  //        });
  //
  //
  //  }

  /*╔══════════════════════════════════════════════════════════╗
    ║              THROWS EXCEPTION - WORK-AROUND              ║
    ╚══════════════════════════════════════════════════════════╝*/
  //  private static void printStatus(CollegeStudent student) {
  //    show(student.getName());
  //    if (student.getGpa() != null) {
  //      if (student.getGpa() < 2.0) {
  //        show(" is on academic probation");
  //      } else {
  //        show(" is in good standing");
  //      }
  //    } else show(" has an unknown gpa");
  //  }

/*╔══════════════════════════════════════════════════════════╗
  ║                    THROWS EXCEPTION                      ║
  ╠══════════════════════════════════════════════════════════╣
  ║ 'CAUSE GPA IS NOT INITIALIZED IN SINGLE-ARGS CONSTRUCTOR ║
  ╚══════════════════════════════════════════════════════════╝*/
  //  private static void printStatus(CollegeStudent student) {
  //    show(student.getName());
  //    if (student.getGpa() < 2.0) {
  //      show(" is on academic probation");
  //    } else {
  //      show(" is in good standing");
  //    }
  //  }

  /*╔══════════════════════════════════════════════════════════╗
    ║                    OPTIONAL SOLUTION                     ║
    ╠══════════════════════════════════════════════════════════╣
    ║ 'CAUSE GPA IS NOT INITIALIZED IN SINGLE-ARGS CONSTRUCTOR ║
    ╚══════════════════════════════════════════════════════════╝*/
  private static void printStatus(CollegeStudent student) {

    show(student.getName());

    java.util.Optional<Float> gpa;
    if ((gpa = student.getGpa()).isPresent()) {
      if (gpa.get() < 2.0) {
        show(" is on academic probation");
      } else {
        show(" is in good standing");
      }
    } else show(" has an unknown gpa");
  }
}