import entity.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*╔═══════════════════════════════════╗
  ║               PEEK                ║
  ╠═══════════════════════════════════╣
  ║ USES or CHANGE the Stream Element ║
  ║               VOID                ║
  ╚═══════════════════════════════════╝*/
public class PeekExample {
  public static void main(String[] args) {
    List<Student> myList = Stream.generate(Student::new)
                               .limit(2)
                               .collect(Collectors.toList());

    System.out.println("\nPerform Actions on Stream-Elements: ");
    myList.stream()
        .peek(element -> element.getName())
        .peek(element -> System.out.println(element.getName()))
        .collect(Collectors.toList());

    System.out.println("\nPerform Action + Change Stream-Elements: ");
    myList.stream()
        .peek(PeekExample::changeName)
        .peek(element -> System.out.println(element.getName()))
        .collect(Collectors.toList());


  }

  private static void changeName(Student p) {
    p.setName(p.getName() + " Doe");
  }
}