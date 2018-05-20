package ro.ubb.donation.web.converter;

import ro.ubb.donation.core.model.Profile;
import ro.ubb.donation.web.dto.ProfileDto;

public class ProfileConverter implements Converter<Profile, ProfileDto> {
    @Override
    public Profile convertDtoToModel(ProfileDto profileDto) {
        return Profile.builder()
                .firstName(profileDto.getFirstName())
                .lastName(profileDto.getFirstName())
                .birthDate(profileDto.getBirthDate())
                .gender(profileDto.getGender())
                .bloodType(profileDto.getBloodType())
                .build();
    }

    @Override
    public ProfileDto convertModelToDto(Profile profile) {
        return ProfileDto.builder()
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .birthDate(profile.getBirthDate())
                .gender(profile.getGender())
                .bloodType(profile.getBloodType())
                .build();
    }
}
