package ro.ubb.donation.web.requests;

import lombok.*;
import ro.ubb.donation.web.dto.AddressDto;
import ro.ubb.donation.web.dto.ProfileDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InfoRequest {
    private AddressDto addressDto;
    private ProfileDto profileDto;
//
//    private String firstName;
//    private String lastName;
//    private String dateOfBirth;
//    private String gender;
//    private String cnp;
//    private String bloodGroup;
//    private String rh;
//    private String email;
//    private String phone;
//    private String homeAddress;
//    private String city;
//    private String country;
//    private String currentHomeAddress;
//    private String currentCity;
//    private String currentCountry;
//    private String allergies;
//    private String diseases;
//    private String chronicIllness;
    private String username;
}
