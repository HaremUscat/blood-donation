package ro.ubb.donation.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.donation.core.model.Request;
import ro.ubb.donation.core.service.RequestService;
import ro.ubb.donation.web.converter.RequestConverter;
import ro.ubb.donation.web.dto.RequestDto;
import ro.ubb.donation.web.response.RequestResponse;

import java.util.*;

@RestController
public class RequestController {
    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/request/{username}", method = RequestMethod.GET)
    public RequestResponse getRequestsByDoctor(@PathVariable String username){
        List<Request> requests = requestService.getRequestsByDoctor( username );

        if (requests.size() == 0){
            return RequestResponse.builder()
                    .status("failure")
                    .requests( new ArrayList<>( ) )
                    .message("No requests for that doctor")
                    .isError(true)
                    .build();
        }

        return RequestResponse.builder()
                .requests( requests )
                .isError( false )
                .status("Success")
                .message("These are all requests!")
                .build();

    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public RequestResponse getAllRequests() {
        List<Request> requests = requestService.findAll();

        return RequestResponse.builder()
                .requests( requests )
                .isError( false )
                .status("Success")
                .message("These are all requests!")
                .build();
    }

}
