package ro.ubb.donation.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.donation.core.model.Request;
import ro.ubb.donation.core.service.RequestService;
import ro.ubb.donation.web.converter.RequestConverter;
import ro.ubb.donation.web.dto.RequestDto;
import ro.ubb.donation.web.requests.BloodRequest;
import ro.ubb.donation.web.response.RequestResponse;

import java.util.*;

@RestController
public class RequestController {
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestConverter requestConverter;

    @RequestMapping(value = "/request/{username}", method = RequestMethod.GET)
    public RequestResponse getRequestsByDoctor(@PathVariable String username){
        System.out.println("A GET request was made on /request/"+username);

        List<Request> request = requestService.getRequestsByDoctor( username );

        if (request.size() == 0){
            return RequestResponse.builder()
                    .status("failure")
                    .requests( new ArrayList<>( ) )
                    .message("No requests for that doctor")
                    .isError(true)
                    .build();
        }

        return RequestResponse.builder()
                .status("Success")
                .message("The user is now logged")
                .isError(false)
                .requests( requestService.getRequestsByDoctor( username ) )
                .build();

    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public Set<RequestDto> getRequests() {
        System.out.println("A GET request was made on /request  ");

        log.trace("getRequests --- method entered");

        List<Request> requests = requestService.findAll();

        Set<RequestDto> requestDtos = new HashSet<>(requestConverter.convertModelsToDtos(requests));

        log.trace("getRequests: requestDtos={}", requestDtos);

        return requestDtos;
    }

}
