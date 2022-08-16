package com.techelevator.services;

import com.techelevator.model.process.Order;

import java.io.IOException;

public interface EmailService {


    //todo - make this a regular method by changing the name and giving it the parameters we want to pass in: subject, toEmail = to, content
    void sendEmailConfirmation(String custEmail, Order order) throws IOException;
}

