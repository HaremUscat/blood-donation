package ro.ubb.donation.web.dto;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProfileDto implements Serializable{
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String bloodType;
}
