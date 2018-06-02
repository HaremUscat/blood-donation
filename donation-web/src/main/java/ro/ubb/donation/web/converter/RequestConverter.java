package ro.ubb.donation.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.donation.core.model.Request;
import ro.ubb.donation.web.dto.RequestDto;

@Component
public class RequestConverter extends AbstractConverter<Request, RequestDto> implements Converter<Request, RequestDto> {
    @Override
    public Request convertDtoToModel(RequestDto requestDto) {
        return Request.builder()
                .thrombocyteUnits( requestDto.getThrombocyteUnits() )
                .redCellsunits( requestDto.getRedCellsunits() )
                .plasmaUnits( requestDto.getPlasmaUnits() )
                .center( requestDto.getDonationCenter() )
                .locationHospital( requestDto.getLocationHospital() )
                .beneficiaryName( requestDto.getBeneficiaryName() )
                .activeDonor( requestDto.isActiveDonor() )
                .urgencyLevel( requestDto.getUrgencyLevel() )
                .bloodGroup( requestDto.getBloodGroup() )
                .rh( requestDto.getRh() )
                .username( requestDto.getUsername() )
                .status( requestDto.getStatus() )
                .build();
    }

    @Override
    public RequestDto convertModelToDto(Request request) {
        return RequestDto.builder()
                .thrombocyteUnits( request.getThrombocyteUnits() )
                .redCellsunits( request.getRedCellsunits() )
                .plasmaUnits( request.getPlasmaUnits() )
                .donationCenter( request.getCenter() )
                .locationHospital( request.getLocationHospital() )
                .beneficiaryName( request.getBeneficiaryName() )
                .activeDonor( request.isActiveDonor())
                .urgencyLevel( request.getUrgencyLevel() )
                .bloodGroup( request.getBloodGroup() )
                .rh( request.getRh() )
                .username( request.getUsername() )
                .status( request.getStatus() )
                .build();
    }
}
