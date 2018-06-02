package ro.ubb.donation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.donation.core.model.Address;
import ro.ubb.donation.core.model.Donation;
import ro.ubb.donation.core.model.Profile;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.service.DonationService;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.web.converter.AddressConverter;
import ro.ubb.donation.web.converter.DonationConverter;
import ro.ubb.donation.web.converter.ProfileConverter;
import ro.ubb.donation.web.dto.DonationDto;
import ro.ubb.donation.web.requests.DonationFormPost;
import ro.ubb.donation.web.response.DonationGetResponse;
import ro.ubb.donation.web.response.DonationPostResponse;

import java.util.Optional;

@RestController
public class DonationController {
    @Autowired
    private DonationService donationService;

    @Autowired
    private DonationConverter donationConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileConverter profileConverter;

    @Autowired
    private AddressConverter addressConverter;

    @RequestMapping(value = "/donation-forms", method = RequestMethod.POST)
    public DonationPostResponse createDonation(@RequestBody DonationFormPost donationForm){
        Optional<User> userOptional = this.userService.getUser(donationForm.getUsername());
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            DonationDto donation = donationForm.getDonationDto();

            this.donationService.createDonation(user,donation.getStatus(),donation.isCancerPast5Years()
            ,donation.isRecentTattoos(),donation.isPregnantOrMenstruating(),donation.isSurgeryPast6Months(),donation.getPulse(),donation.getBloodPressure(),
                    donation.getWeight(),donation.getDonationBeneficiary());

            return DonationPostResponse.builder()
                    .isError(false)
                    .status("Success")
                    .message("Donation in PENDING status was successfully created").build();
        }
        return DonationPostResponse.builder().isError(true).message("The user with this username doesn't exist!").status("Error").build();
    }

    @RequestMapping(value = "/donation-forms/{username}", method = RequestMethod.GET)
    public DonationGetResponse getDonationFormInfo(
            @PathVariable String username){
        Optional<User> userOptional = this.userService.getUser(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Donation donation;
            Profile profile = user.getProfile();
            Address address = user.getAddress();
            Optional<Donation> optionalDonation = this.donationService.findDonationByUser(user);
            if(profile == null)
                profile = Profile.getEmptyProfile();
            if (address == null)
                address = Address.getEmptyAddress();
            donation = optionalDonation.orElseGet(Donation::getEmptyDonation);
            return DonationGetResponse.builder()
                    .isError(false)
                    .status("Success")
                    .message("")
                    .addressDto(this.addressConverter.convertModelToDto(address))
                    .profileDto(this.profileConverter.convertModelToDto(profile))
                    .donationDto(this.donationConverter.convertModelToDto(donation))
                    .build();
        }
        else
            return DonationGetResponse.builder()
                    .status("Error")
                    .message("The user doesn't exist")
                    .addressDto(this.addressConverter.convertModelToDto(Address.getEmptyAddress()))
                    .profileDto(this.profileConverter.convertModelToDto(Profile.getEmptyProfile()))
                    .donationDto(this.donationConverter.convertModelToDto(Donation.getEmptyDonation())).build();
    }
}
