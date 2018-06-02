package ro.ubb.donation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.donation.core.model.Address;
import ro.ubb.donation.core.model.Profile;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.service.DonationService;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.web.converter.AddressConverter;
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

    @RequestMapping(value = "/donation-forms", method = RequestMethod.GET)
    public DonationGetResponse getDonationFormInfo(@PathVariable String username){
        Optional<User> userOptional = this.userService.getUser(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Profile profile = user.getProfile();
            Address address = user.getAddress();
        }
        return null;
    }
}
