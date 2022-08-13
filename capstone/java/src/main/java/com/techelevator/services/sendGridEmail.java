package com.techelevator.services;
import com.sendgrid.*;
import java.io.IOException;


public class sendGridEmail implements email{
//todo - make this a regular method by changing the name and giving it the parameter we want to pass in: subject, to, content
    public static void main(String[] args) throws IOException {
        Email from = new Email("backrowboyzpizza@gmail.com");
        String subject = "This email is from our java server";
        Email to = new Email("mikestill12@gmail.com");
        Content content = new Content("text/plain", "Hi Mike, how does it feel to get an email from your backend server? - Jonathan  ");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }


}
