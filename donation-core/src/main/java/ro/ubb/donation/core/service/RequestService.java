package ro.ubb.donation.core.service;

import ro.ubb.donation.core.model.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    Optional<Request> findRequest(int requestId);
    
    List<Request> findAll();
    
    Request updateRequest(int requestId, Integer thrombocyteUnits, Integer redCellsunits, Integer plasmaUnits, Integer donationCenterId,
                          String locationHospital, String beneficiaryName, String activeDonor, String urgencyLevel,
                          String bloodGroup, String rh, String username, String status);

    Request createRequest(Integer thrombocyteUnits, Integer redCellsunits, Integer plasmaUnits, Integer donationCenterId,
                          String locationHospital, String beneficiaryName, String activeDonor, String urgencyLevel,
                          String bloodGroup, String rh, String username, String status);

    void deleteRequest(int requestId);

    List<Request> getRequestsByDoctor(String username);
}
