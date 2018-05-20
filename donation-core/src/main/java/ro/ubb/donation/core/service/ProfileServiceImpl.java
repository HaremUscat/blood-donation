package ro.ubb.donation.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.donation.core.model.Address;
import ro.ubb.donation.core.model.Profile;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.repository.ProfileRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private static final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Optional<Profile> findProfile(int profileId) {
        return profileRepository.findById(profileId);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    @Transactional
    public Profile updateProfile(int profileId, String firstName, String lastName, Date birthDate, String gender, String bloodType) {
        log.trace("updateProfile: profileId={}, firstName={}, lastName={}, birthDate={}, gender={}, bloodType={}", profileId, firstName, lastName, birthDate, gender, bloodType);

        Optional<Profile> profile = profileRepository.findById(profileId);
        profile.ifPresent(p -> {
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setGender(gender);
                p.setBloodType(bloodType);
            }
        );

        log.trace("updateProfile={}");
        return profile.orElse(null);
    }

    @Override
    @Transactional
    public Profile createProfile(String firstName, String lastName, Date birthDate, String gender, String bloodType) {
        log.trace("updateProfile: profileId={}, firstName={}, lastName={}, birthDate={}, gender={}, bloodType={}, address={}", firstName, lastName, birthDate, gender, bloodType);
        Profile profile=Profile.builder()
                            .firstName(firstName)
                            .lastName(lastName)
                            .birthDate(birthDate)
                            .gender(gender)
                            .bloodType(bloodType)
                            .build();
        profileRepository.save(profile);

        log.trace("updateProfile={}");
        return profile;
    }

    @Override
    @Transactional
    public void deleteProfile(int profileId) {
        log.trace("deleteProfile: profileId={}", profileId);

        Optional<Profile> profile = profileRepository.findById(profileId);
        profile.ifPresent(p-> profileRepository.delete(p));
    }

    @Override
    public Optional<Profile> getProfileByUser(User user) {
        log.trace("getProfileByUser: user = {}", user);

        return profileRepository.findAll().stream().filter(p->user.equals(user)).findFirst();
    }
}
