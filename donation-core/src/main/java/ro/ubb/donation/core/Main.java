package ro.ubb.donation.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.donation.core.model.Address;
import ro.ubb.donation.core.model.Profile;
import ro.ubb.donation.core.model.Role;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.repository.RoleRepository;
import ro.ubb.donation.core.repository.UserRepository;
import ro.ubb.donation.core.service.AddressService;
import ro.ubb.donation.core.service.ProfileService;
import ro.ubb.donation.core.service.RoleService;
import ro.ubb.donation.core.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.donation.core");

        RoleService roleService = context.getBean(RoleService.class);
        ProfileService profileService = context.getBean(ProfileService.class);
        UserService userService = context.getBean(UserService.class);
        AddressService addressService = context.getBean(AddressService.class);

        Role donor = roleService.createRole("Donor");
        Role doctor = roleService.createRole("Doctor");
        Role pers = roleService.createRole("Hospital Personnel");


        Address addr = addressService.createAddress("home1", "curhome", "city", "coun", "curc", "curc");
        Address addr2 = addressService.createAddress("home2", "curhome", "city", "coun", "curc", "curc");



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = sdf.parse("21/12/2012");
            Profile p = profileService.createProfile("profile1", "ln", d, "female", "type");
            Profile p2 = profileService.createProfile("profile2", "ln", d, "female", "type");

            User u1=userService.createUser("user1", "pas1", true, donor);
            u1.setProfile(p);
            u1.setAddress(addr);
            User u2=userService.createUser("user2", "pas2", true, doctor);
            userService.updateUser(u2.getId(), u2.getUsername(), u2.getPassword(), u2.isLogged(), u2.getRole(), addr2, p2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addressService.deleteAddress(1);
        //profileService.deleteProfile(1);
        //userService.deleteUser(1);

//        userService.createUser("mariaungur1","pass",true,roleService.getRoleByDescription("Donor").orElse(null));
//        userService.createUser("marialazar1","pass",false,roleService.getRoleByDescription("Donor").orElse(null));
//        userService.createUser("nicoletaungur1","pass",true,roleService.getRoleByDescription("Doctor").orElse(null));
//        userService.createUser("mariaungur2","pass",true,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
//        userService.createUser("marialazar2","pass",false,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
//        userService.createUser("nicoletaungur2","pass",true,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
//


        System.out.println("###############################################3");
        List<Address> adrs=addressService.findAll();
        for (Address a:adrs){
            System.out.println(a);
        }
        System.out.println("###############################################3");
        List<Profile> profiles = profileService.findAll();
        for (Profile profile : profiles) {
            System.out.println(profile);
        }
        System.out.println("#################################################33333333");
        //UserService userService = context.getBean(UserService.class);
        List<User> users = userService.findAll();
        for (User user : users){
            System.out.println(user);
        }



//        userService.createUser("mariaungur1","pass",true,roleService.getRoleByDescription("Donor").orElse(null));
//        userService.createUser("marialazar1","pass",false,roleService.getRoleByDescription("Donor").orElse(null));
//        userService.createUser("nicoletaungur1","pass",true,roleService.getRoleByDescription("Doctor").orElse(null));
//        userService.createUser("mariaungur2","pass",true,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
//        userService.createUser("marialazar2","pass",false,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
//        userService.createUser("nicoletaungur2","pass",true,roleService.getRoleByDescription("Hospital Personnel").orElse(null));
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
    @Transactional
    public void seteaza(User u2, Address addr2, Profile p2){
        u2.setAddress(addr2);
        u2.setProfile(p2);
    }


}
