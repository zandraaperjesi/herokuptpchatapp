package com.zandraa.perjesi.service;

import com.zandraa.perjesi.model.IncomingMessage;
import com.zandraa.perjesi.model.ReceiveResponse;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

  public ReceiveResponse validate(IncomingMessage toValidate) {
    if (toValidate.getMessage().getText().equals(null)) {
      return new ReceiveResponse("message missing");
    }
    if (toValidate.getMessage().getUsername().equals(null)) {
      return new ReceiveResponse("username missing");
    }
    if (toValidate.getClient().getId().equals(null)) {
      return new ReceiveResponse("id missing");
    }
    return new ReceiveResponse("ok");
  }
}
