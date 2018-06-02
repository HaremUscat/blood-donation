package ro.ubb.donation.web.requests;

import lombok.*;
import ro.ubb.donation.web.dto.RequestDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BloodRequest {
    private RequestDto requestDto;
    private String username;
}
