package it2.develhope.Angelo.InterceptormiddlewareExample.interceptor;

import it2.develhope.Angelo.InterceptormiddlewareExample.entitties.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class LoggedUserInterceptor implements HandlerInterceptor {

    //modo grossolano per definire una sorta di database
    public static List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"Angelo","Zammataro", "Palermo"),
            new User(2,"Kemonia","Riccobono", "Palermo"),
            new User(3,"Federico","Zammataro", "Palermo"),
            new User(4,"Maya","Zammataro", "Palermo")
    ));
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userIdString = request.getHeader("userId");
        if(userIdString == null){
            return true;
        }
        long userId = Long.parseLong(userIdString);
        Optional<User> user = users.stream().filter(singleUser->{
            return singleUser.getId() == userId;
        }).findFirst();

        if(user.isPresent()){
            request.setAttribute("LoggedUserInterceptor-user", user.get());
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
