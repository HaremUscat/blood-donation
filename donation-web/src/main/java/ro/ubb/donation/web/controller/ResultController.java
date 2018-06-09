package ro.ubb.donation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.donation.core.model.Donation;
import ro.ubb.donation.core.model.Result;
import ro.ubb.donation.core.service.DonationService;
import ro.ubb.donation.core.service.ResultService;
import ro.ubb.donation.web.converter.ResultConverter;
import ro.ubb.donation.web.dto.ResultDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ResultController {
    @Autowired
    private ResultConverter resultConverter;

    @Autowired
    private DonationService donationService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/results/{username}", method = RequestMethod.GET)
    public Set<ResultDto> getAllResultsForUsername(@PathVariable String username){
        List<Donation> donations = donationService.findDonationByUsername( username );
        donations = donations.stream().filter( d -> d.getResult() != null ).collect(Collectors.toList());
        List<Result> results = new ArrayList<>( );
        donations.forEach( d -> results.add( d.getResult() ) );

        return new HashSet<>( resultConverter.convertModelsToDtos( results ) );
    }
}
