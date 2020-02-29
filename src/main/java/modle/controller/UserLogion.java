package modle.controller;

import comment.supper.G5;
import modle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserLogion {
    @Autowired
    UserService userService;
    @Autowired
    G5 g5;
    @PostMapping("/enter")
    public String enter(@RequestParam Map map) {

        Map map1 = userService.userLogion(map);
        String username = g5.Gi51(map.get("username").toString());
        if(username.equals("5")){
            return "ac";
        }else {
            if (map1 == null) {
                g5.Gi5(map.get("username").toString());
                return "sb";
            } else {

                return "sd";
            }
        }
    }


}
