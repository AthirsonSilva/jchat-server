package com.jchat.controller;

import com.jchat.model.Message;
import com.jchat.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ApiController {
    private final MessageService messageService;

    @GetMapping
    public List<Message> fetchPreviousRoomMessages(@RequestParam("room") String room) {
        return messageService.fetchPreviousRoomMessages(room);
    }
}
