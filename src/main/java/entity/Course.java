package entity;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
public class Course {

    private String courseName;

    @Getter
    private List<Student> studentList;

    public Course(String courseName, int studentNumber) {
        this.courseName = courseName;

        this.studentList =
                Stream.generate(Student::new)
                        .limit(studentNumber)
                        .map((s) -> {
                            s.setName(s.getName() + " : " + courseName);
                            return s;})
                        .collect(Collectors.toList());
    }
}