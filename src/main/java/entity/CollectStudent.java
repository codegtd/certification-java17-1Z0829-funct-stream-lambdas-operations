package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class CollectStudent {
    protected String name;
    @Getter
    private float gpa;
}