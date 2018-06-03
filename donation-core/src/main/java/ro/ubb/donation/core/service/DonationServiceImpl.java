package ro.ubb.donation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.donation.core.model.Donation;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.repository.DonationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Override
    public Optional<Donation> findDonation(int donationId) {
        return this.donationRepository.findById(donationId);
    }

    @Override
    public Optional<Donation> findDonationByUser(User user)
    {
        List<Donation> donations = this.donationRepository.findAll().stream().filter(d->d.getUser().getId() == user.getId() && !d.getStatus().equals("CLOSED")).collect(Collectors.toList());
        if(donations.isEmpty())
            return Optional.empty();
        else
            return Optional.ofNullable(donations.get(0));
    }

    @Override
    public List<Donation> findAll() {
        return this.donationRepository.findAll();
    }

    @Override
    @Transactional
    public Donation updateDonation(int donationId, String status, String rejectionReason,
                                   boolean cancerPast5Years, boolean recentTattos, boolean pregnantOrMenstruating,
                                   boolean surgeryPast6Months, int pulse, int bloodPresure, float weight,
                                   String donationBeneficiary)
    {
        Optional<Donation> donation = this.donationRepository.findById(donationId);
        if(donation.isPresent()){
            Donation d = donation.get();
            d.setStatus(status);
            d.setRejectionReason(rejectionReason);
            d.setCancerPast5Years(cancerPast5Years);
            d.setRecentTattoos(recentTattos);
            d.setPregnantOrMenstruating(pregnantOrMenstruating);
            d.setSurgeryPast6Months(surgeryPast6Months);
            d.setPulse(pulse);
            d.setBloodPressure(bloodPresure);
            d.setWeight(weight);
            d.setDonationBeneficiary(donationBeneficiary);
        }
        return donation.orElse(null);
    }

    @Override
    @Transactional
    public Donation createDonation(User user, String status, boolean cancerPast5Years,
                                   boolean recentTattos, boolean pregnantOrMenstruating, boolean surgeryPast6Months,
                                   int pulse, int bloodPresure, float weight, String donationBeneficiary) {
        Date date = new Date();
        System.out.println(date);
        Donation donation = Donation.builder()
                .status(status)
                .createdOn(date)
                .user(user)
                .cancerPast5Years(cancerPast5Years)
                .recentTattoos(recentTattos)
                .pregnantOrMenstruating(pregnantOrMenstruating)
                .surgeryPast6Months(surgeryPast6Months)
                .pulse(pulse)
                .bloodPressure(bloodPresure)
                .weight(weight)
                .donationBeneficiary(donationBeneficiary)
                .build();
        this.donationRepository.save(donation);
        return donation;
    }

    @Override
    @Transactional
    public void deleteDonation(int donationId) {
        Optional<Donation> donation = this.donationRepository.findById(donationId);
        donation.ifPresent(d-> this.donationRepository.delete(d));
    }

}

