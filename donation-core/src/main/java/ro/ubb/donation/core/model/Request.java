package ro.ubb.donation.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "request", uniqueConstraints = {@UniqueConstraint( columnNames = {"username"})})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "thrombocyte_units", nullable = false)
    private Integer thrombocyteUnits;

    @Column(name = "red_cells_units", nullable = false)
    private Integer redCellsunits;

    @Column(name = "plasma_units", nullable = false)
    private Integer plasmaUnits;

    @Column(name = "id_donation_center", nullable = false)
    private Integer donationCenterId;

    @Column(name = "location_hospital", nullable = false)
    private String locationHospital;

    @Column(name = "beneficiary_name", nullable = false)
    private String beneficiaryName;

    @Column(name = "active_donor", nullable = false)
    private String activeDonor;

    @Column(name = "urgency_level", nullable = false)
    private String urgencyLevel;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "rh", nullable = false)
    private String rh;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "status", nullable = false)
    private String status;

    public Request(Integer thrombocyteUnits, Integer redCellsunits, Integer plasmaUnits, Integer donationCenterId,
                        String locationHospital, String beneficiaryName, String activeDonor, String urgencyLevel,
                        String bloodGroup, String rh, String username, String status){
        this.thrombocyteUnits = thrombocyteUnits;
        this.redCellsunits = redCellsunits;
        this.plasmaUnits = plasmaUnits;
        this.donationCenterId = donationCenterId;
        this.locationHospital = locationHospital;
        this.beneficiaryName = beneficiaryName;
        this.activeDonor = activeDonor;
        this.urgencyLevel = urgencyLevel;
        this.bloodGroup = bloodGroup;
        this.rh = rh;
        this.username = username;
        this.status = status;
    }

    @Override
    public String toString(){
        return "Request{" +
                "id=" + id +
                ", thrombocytes_units=" + thrombocyteUnits +
                ", plasma_units=" + plasmaUnits +
                ", id_donation_center=" + donationCenterId +
                ", location_hospital=" + locationHospital +
                ", beneficiary=" + beneficiaryName +
                ", active_donor=" + activeDonor +
                ", urgency_level=" + urgencyLevel +
                ", blood_group=" + bloodGroup +
                ", rh=" + rh +
                ", username=" + username +
                ", status=" + status;
    }
}
