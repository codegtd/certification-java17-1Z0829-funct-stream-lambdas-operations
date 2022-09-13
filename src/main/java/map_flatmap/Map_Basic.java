package map_flatmap;

import entity.Student;

import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*╔═════════════════════════════════════════════╗
  ║                    MAP                      ║
  ╠═════════════════════════════════════════════╣
  ║ Apply Function/Lambda in the Stream Element ║
  ║       RETURN the elements as Stream         ║
  ╚═════════════════════════════════════════════╝*/
public class Map_Basic {
  public static void main(String[] args) {

    List<Student> list1 =
         Stream.generate(Student::new)
               .limit(3)
               .peek(element -> show("Student pre Map: " + element.getName()))
               .collect(Collectors.toList());

    List<Student> changedList =
         list1.stream()
              .map(Map_Basic::changeAndReturnStudent)
              .map(element -> {
                show("Student pos Map: " + element.getName());
                return element;
              })
              .collect(Collectors.toList());


  }

  private static void show(String element) {

    System.out.println(element);
  }

  private static Student changeAndReturnStudent(Student p) {

    p.setName(p.getName() + " Doe");
    return p;
  }

  private static java.util.Map.Entry<Integer, Student> mapStudent(Student p) {

    return new AbstractMap.SimpleEntry<Integer, Student>(p.getStudentId(), p);
  }

}