package ro.ubb.donation.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.donation.core.model.Role;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.service.RoleService;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.web.converter.UserConverter;
import ro.ubb.donation.web.dto.UserDto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserConverter userConverter;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Set<UserDto> getUsers() {
        log.trace("getUsers --- method entered");

        List<User> users = userService.findAll();

        Set<UserDto> userDtos = new HashSet<>(userConverter.convertModelsToDtos(users));

        log.trace("getDisciplines: disciplineDtos={}", userDtos);

        return userDtos;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserDto createUser(
            @RequestBody final UserDto userDto) {
        log.trace("createUser: userDto={}", userDto);

        Optional<Role> role = roleService.findRole(1);

        User user = userService.createUser(userDto.getUsername(),userDto.getPassword(), true, role.get());

        UserDto result = userConverter.convertModelToDto(user);

        log.trace("createUser: result={}", result);

        return result;
    }
}
