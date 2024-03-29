package com.jchat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.jchat.model.Message;
import com.jchat.services.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
// array of origins can be specified
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*", maxAge = 3600)
public class ChatController {
	private final SimpMessagingTemplate simpMessagingTemplate;
	private final MessageService messageService;

	@MessageMapping("/message")
	@SendTo("/chatroom/public")
	public Message receivePublicMessage(@Payload Message message) {
		log.info("Message sent to /chatroom/public --> " + message);

		return messageService.saveMessage(message);
	}

	@MessageMapping("/private-message")
	public Message receivePrivateMessage(@Payload Message message) {
		log.info("Message sent to " + message.getReceiverName());
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);

		messageService.saveMessage(message);

		return message;
	}
}
