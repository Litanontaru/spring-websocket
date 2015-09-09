package old;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendToUser("/queue/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/hello_all")
    @SendTo("/topic/greetings")
    public Greeting greetingAll(HelloMessage message) throws Exception {
        return new Greeting("Hello to all , " + message.getName() + "!");
    }
}
