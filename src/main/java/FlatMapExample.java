import entity.Course;
import entity.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
  public static void main(String[] args) {
//https://www.youtube.com/watch?v=ZT_5eS6IpD8
    List<Student> studentList =
         Stream.of(
                    new Course("Geometry 101", 2),
                    new Course("Java 101", 2))
               .flatMap(course -> course.getStudentList().stream())
               .collect(Collectors.toList());

    System.out.println("Complete Student Population: ");
    studentList.forEach(System.out::println);
  }
}