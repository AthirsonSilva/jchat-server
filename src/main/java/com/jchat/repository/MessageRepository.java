package com.jchat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jchat.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
	@Query("{ 'receiverName' : ?0, 'status' : ?1 }")
	List<Message> findAllByReceiverName(String room, String status);
}
