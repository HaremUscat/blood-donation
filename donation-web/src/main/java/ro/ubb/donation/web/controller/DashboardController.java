package ro.ubb.donation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.donation.core.model.Donation;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.service.DonationService;
import ro.ubb.donation.core.service.ResultService;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.web.response.DashboardResponse;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DashboardController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private DonationService donationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dashboard-info/{username}", method = RequestMethod.GET)
    public DashboardResponse getDashboardInfo(@PathVariable String username){
        Optional<User> userOptional = userService.getUser(username);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            boolean hasTestResults = false;
            List<Donation> donations = donationService.findAll().stream().filter(d->d.getUser().getId()==user.getId()).collect(Collectors.toList());
            if (!donations.isEmpty()){
                Donation donation = donations.get(donations.size()-1);
                if (donation.getResult()!=null){
                    hasTestResults = true;
                }
                Date appointmentDate = donation.getAppointment_date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(appointmentDate);
                cal.add(Calendar.MONTH, 2);
                Date resultDate = cal.getTime();

                return DashboardResponse.builder()
                        .firstName(user.getProfile().getFirstName())
                        .illnessDiscovered(donation.getResult().isIllnessDiscovered())
                        .illnessInfo(donation.getResult().getIllnessInfo())
                        .nextPossibleDonationDate(resultDate.toString())
                        .hasNewTestResults(hasTestResults)
                        .status("Success")
                        .isError(false)
                        .message("The dashboard info was returned")
                        .build();
            }
            else {
                return DashboardResponse.builder()
                        .firstName(user.getProfile().getFirstName())
                        .illnessDiscovered(false)
                        .illnessInfo("")
                        .nextPossibleDonationDate(new Date().toString())
                        .hasNewTestResults(hasTestResults)
                        .status("Success")
                        .isError(false)
                        .message("This user does not have another donation")
                        .build();
            }
        }
        return DashboardResponse.builder()
                .firstName("")
                .illnessDiscovered(false)
                .illnessInfo("")
                .nextPossibleDonationDate("")
                .hasNewTestResults(false)
                .status("Fail")
                .isError(true)
                .message("This user does not exist")
                .build();
    }

}
