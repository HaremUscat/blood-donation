package ro.ubb.donation.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.donation.core.model.Container;
import ro.ubb.donation.core.service.ContainerService;
import ro.ubb.donation.web.converter.ContainerConverter;
import ro.ubb.donation.web.dto.ContainerDto;
import ro.ubb.donation.web.requests.ContainerForm;
import ro.ubb.donation.web.response.ContainerResponse;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ContainerController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ContainerService containerService;

    @Autowired
    private ContainerConverter containerConverter;
    private List<Container> containers;


    @RequestMapping(value = "/containers/{centerId}", method = RequestMethod.DELETE)
    public ContainerResponse removeExpiredContainersByCenter(@PathVariable int centerId){
        try{
            List<Container> containers = containerService.getContainersByCenterId(centerId);
            Date currentDate = new Date();
            System.out.println(currentDate);
            List<Container> expiredContainers = containers.stream().filter( c -> c.getExpirationDate().compareTo(currentDate) < 0).collect( Collectors.toList() );
            expiredContainers.forEach( c -> containerService.deleteContainer( c.getId() ) );
            return ContainerResponse.builder()
                    .status("Success")
                    .message("Containers by centerId deleted")
                    .isError(true)
                    .build();
        } catch (Exception e){
            return ContainerResponse.builder()
                    .status("Error")
                    .message(e.getMessage())
                    .isError(true)
                    .build();
        }
    }

    @RequestMapping(value = "/containers", method = RequestMethod.DELETE)
    public ContainerResponse removeFirstNContainersByCenter(@RequestBody ContainerForm containerForm){
        try{
            List<Container> containers = containerService.findAll();
            containers = containers.stream().filter( c -> c.getComponentType().equals( containerForm.getContainerDto().getComponentType() ) ).collect( Collectors.toList() );
            containers.sort( Comparator.comparing( Container::getExpirationDate ) );

            Integer nrContainers = containerForm.getNumberOfContainers();
            while (nrContainers != 0){
                Container container = containers.get( 0 );
                containerService.deleteContainer( container.getId() );
                containers.remove( 0 );
                nrContainers--;
            }
            return ContainerResponse.builder()
                    .status("Success")
                    .message("Containers deleted")
                    .isError(true)
                    .build();
        } catch (Exception e){
            return ContainerResponse.builder()
                    .status("Error")
                    .message(e.getMessage())
                    .isError(true)
                    .build();
        }
    }

/*
    @RequestMapping(value = "/containers/{centerId}", method = RequestMethod.GET)
    public Set<ContainerDto> getAllContainersExpiredByCenter(@PathVariable int centerId) {
        List<Container> containers = containerService.getContainersByCenterId(centerId);
        Date currentDate = new Date();
        System.out.println(currentDate);
        List<Container> expiredContainers = containers.stream().filter( c -> c.getExpirationDate().compareTo(currentDate) < 0).collect( Collectors.toList() );
        Set<ContainerDto> containerDtos = new HashSet<>( containerConverter.convertModelsToDtos( expiredContainers ) );

        return containerDtos;
    }
*/

    @RequestMapping(value = "/containers/{centerId}", method = RequestMethod.GET)
    public Set<ContainerDto> getAllContainersByCenter(@PathVariable int centerId) {
        List<Container> containers = containerService.getContainersByCenterId(centerId);
        Set<ContainerDto> containerDtos = new HashSet<>( containerConverter.convertModelsToDtos( containers ) );

        return containerDtos;
    }


    @RequestMapping(value = "/containers", method = RequestMethod.GET)
    public Set<ContainerDto> getAllContainers() {
        List<Container> containers = containerService.findAll();
        Set<ContainerDto> containerDtos = new HashSet<>( containerConverter.convertModelsToDtos( containers ) );

        return containerDtos;
    }
}
