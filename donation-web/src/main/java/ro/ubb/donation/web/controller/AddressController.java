package ro.ubb.donation.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.donation.core.service.AddressService;
import ro.ubb.donation.web.converter.AddressConverter;

public class AddressController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressConverter addressConverter;
}
