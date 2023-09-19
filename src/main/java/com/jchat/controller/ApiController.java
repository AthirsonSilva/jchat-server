package com.jchat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jchat.model.Message;
import com.jchat.services.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*", maxAge = 3600)
public class ApiController {
	private final MessageService messageService;

	@GetMapping
	@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*", maxAge = 3600)
	public List<Message> fetchPreviousRoomMessages(@RequestParam("room") String room) {
		log.info("Fetching previous messages from room " + room);

		return messageService.fetchPreviousRoomMessages(room);
	}
}
