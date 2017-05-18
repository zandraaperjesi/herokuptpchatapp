package com.zandraa.perjesi.repository;

import com.zandraa.perjesi.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{
}
