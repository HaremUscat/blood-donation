package ro.ubb.donation.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.donation.core.model.Role;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.repository.RoleRepository;
import ro.ubb.donation.core.repository.UserRepository;
import ro.ubb.donation.core.service.RoleService;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.core.service.UserServiceImpl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.donation.core.config");

        RoleRepository roleRepository = context.getBean(RoleRepository.class);

        Role r1 = Role.builder().description("Donor").build();
        Role r2 = Role.builder().description("Doctor").build();

        UserRepository userRepository = context.getBean(UserRepository.class);

        User u1 = User.builder().logged(false).username("mariaungur").password("pass").build();
        User u2 = User.builder().logged(false).username("marialazar").password("pass").build();

        UserService userService= context.getBean(UserService.class);

        RoleService roleService = context.getBean(RoleService.class);

        roleRepository.save(r1);
        roleRepository.save(r2);

        u1.setRole(r1);
        u2.setRole(r2);

        userRepository.save(u1);
        userRepository.save(u2);

        userService.deleteUser(1);
//
//        List<User> list=userRepository.findAll();
//        for (User u:list){
//            System.out.println(u);
//        }

        System.out.println("------------------------------------");
        List<Role> list2=roleRepository.findAll();
        for (Role u:list2){
            System.out.println(u);
        }

        System.out.print("Bye");

    }
}
