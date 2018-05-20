package ro.ubb.donation.core.service;

import ro.ubb.donation.core.model.Address;
import ro.ubb.donation.core.model.Profile;
import ro.ubb.donation.core.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Optional<Profile> findProfile(int profileId);

    List<Profile> findAll();

    Profile updateProfile(int profileId, String firstName, String lastName, Date birthDate, String gender, String bloodType);

    Profile createProfile(String firstName, String lastName, Date birthDate, String gender, String bloodType);

    void deleteProfile(int profileId);

    Optional<Profile> getProfileByUser(User user);

}
