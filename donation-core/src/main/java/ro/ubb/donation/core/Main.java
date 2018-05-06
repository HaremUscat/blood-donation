package ro.ubb.donation.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.donation.core.model.Role;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.repository.RoleRepository;
import ro.ubb.donation.core.repository.UserRepository;
import ro.ubb.donation.core.service.RoleService;
import ro.ubb.donation.core.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.donation.core");

        RoleService roleService = context.getBean(RoleService.class);
        roleService.createRole("Donor");
        roleService.createRole("Doctor");
        roleService.createRole("Hospital Personnel");

        UserService userService = context.getBean(UserService.class);
        userService.createUser("mariaungur1","pass",true,roleService.getRoleByDescription("Donor").orElse(null));
        userService.createUser("marialazar1","pass",false,roleService.getRoleByDescription("Donor").orElse(null));
        userService.createUser("nicoletaungur1","pass",true,roleService.getRoleByDescription("Doctor").orElse(null));
        userService.createUser("mariaungur2","pass",true,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
        userService.createUser("marialazar2","pass",false,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
        userService.createUser("nicoletaungur2","pass",true,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
//        userService.deleteUser(1);
//        userService.deleteUser(4);
//        roleService.deleteRole(3);

//        List<Role> roles = roleService.findAll();
//        roles.forEach(System.out::println);
//
//        List<User> users = userService.findAll();
//        users.forEach(System.out::println);
//        System.out.print("Bye");


    }
}
