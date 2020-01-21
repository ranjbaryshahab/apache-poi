package ir.maktab;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
