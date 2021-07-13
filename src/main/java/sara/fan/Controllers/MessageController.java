package sara.fan.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sara.fan.domain.Message;
import sara.fan.domain.views;
import sara.fan.repo.MessageRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messages) {
        this.messageRepo = messages;
    }

    @GetMapping
    @JsonView(views.idName.class)
    public List<Message> messages() {
        return messageRepo.findAll();
    }


    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
   public Message create(@RequestBody Message message){
        return messageRepo.save(message);
    }
    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDb,
                                     @RequestBody Message message){
        BeanUtils.copyProperties(message,messageFromDb,"id");
        message.setLocalDateTime(LocalDateTime.now());
        return messageRepo.save(messageFromDb);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message){
        messageRepo.delete(message);
    }
}
