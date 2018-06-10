package ro.ubb.donation.web.response;

import lombok.*;
import ro.ubb.donation.core.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClosestDonorResponse {
    private String status;
    private boolean isError;
    private String message;
    private User user1;
    private String distance1;
    private User user2;
    private String distance2;
    private User user3;
    private String distance3;
}

