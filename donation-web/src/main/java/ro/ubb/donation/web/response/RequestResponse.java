package ro.ubb.donation.web.response;

import lombok.*;
import ro.ubb.donation.core.model.Request;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestResponse {
    private List<Request> requests;
    private String status;
    private Boolean isError;
    private String message;

}
