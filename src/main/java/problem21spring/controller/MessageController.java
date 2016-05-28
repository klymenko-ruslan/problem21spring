package problem21spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import problem21spring.model.Message;
import problem21spring.service.MessageService;

/**
 * Created by rklimemnko on 28.05.2016.
 */
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/messages",method = RequestMethod.POST)
    public ResponseEntity<Integer> messages(@RequestBody Message message) {
        try {
            return new ResponseEntity<Integer>(messageService.handleMessage(message), HttpStatus.OK);
        } catch(DuplicateKeyException e) {
            return new ResponseEntity<Integer>(-1, HttpStatus.CONFLICT);
        }
    }
}
