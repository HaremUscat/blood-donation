package ro.ubb.donation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.donation.core.model.Center;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.service.CenterService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import ro.ubb.donation.core.service.UserService;
import ro.ubb.donation.web.requests.ClosestDonorRequest;
import ro.ubb.donation.web.response.ClosestDonorResponse;
import ro.ubb.donation.web.utils.DistancePojo;

@RestController
public class FindDonorController {
    @Autowired
    private CenterService centerService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/closest-donors/{centerID}", method = RequestMethod.POST)
    public ClosestDonorResponse getTheClosestNeighbour(
            @PathVariable final int centerID,
            @RequestBody final ClosestDonorRequest closestDonor) {
        Optional<Center> c = centerService.findCenter(centerID);
        Map<User , Float> results = new HashMap<>();
        ClosestDonorResponse closestDonorResponse=null;

        if (c.isPresent()) {
            String origin = c.get().getAddress();
            //String origin = "Cluj+Napoca"; the address should be like this
            List<User> users = userService.findAll();
            URL url = null;
            for (User u: users) {
                String dest = u.getAddress().getHomeAddress();
                //String dest = "Targu+Mures";
                try {
                    url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + dest);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    String line, outputString = "";
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        outputString += line;
                    }
                    System.out.println(outputString);
                    DistancePojo capRes = new Gson().fromJson(outputString, DistancePojo.class);
                    String dist = capRes.getRows()[0].getElements()[0].getDistance().getText();

                    String[] array = dist.split(" ");
                    float nr = Float.valueOf(array[0]);
                    results.put(u, nr);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            List<User> closestUsers=results.keySet().stream().filter(p->p.getProfile().getRh().equals(closestDonor.getRh()) && p.getProfile().getBloodType().equals(closestDonor.getBloodType())).collect(Collectors.toList());
            for (User us: results.keySet()){
                if (!closestUsers.contains(us)){
                    results.remove(us);
                }
            }
            Map<User, Float> usersSorted = this.getClosestUsers(results);
            closestDonorResponse = getFirstDonors(usersSorted);
        }else{
            closestDonorResponse = ClosestDonorResponse.builder()
                    .isError(true)
                    .message("No such center")
                    .status("Error")
                    .user1(null)
                    .user2(null)
                    .user3(null)
                    .distance1("")
                    .distance2("")
                    .distance3("")
                    .build();
        }
        return closestDonorResponse;
    }

    public Map<User, Float> getClosestUsers(Map<User, Float> users){
        Map<User,Float> result = users.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }

    public ClosestDonorResponse getFirstDonors(Map<User, Float> users){
        int i=0;
        User user1=null;
        User user2=null;
        User user3=null;
        String distance1="";
        String distance2="";
        String distance3="";

        for (Map.Entry<User, Float> entry : users.entrySet())
        {
            if(i==0){
                user1 = entry.getKey();
                distance1 = entry.getValue().toString();
            }else if(i==1){
                user2 = entry.getKey();
                distance2 = entry.getValue().toString();
            }else{
                user3 = entry.getKey();
                distance3 = entry.getValue().toString();
            }
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        ClosestDonorResponse closestDonorResponse = ClosestDonorResponse.builder()
                .isError(false)
                .message("List with 3 closest donors")
                .status("Success")
                .user1(user1)
                .user2(user2)
                .user3(user3)
                .distance1(distance1)
                .distance2(distance2)
                .distance3(distance3)
                .build();
        return closestDonorResponse;
    }

}

