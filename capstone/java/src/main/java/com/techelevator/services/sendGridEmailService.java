package com.techelevator.services;
import com.sendgrid.*;
import com.techelevator.model.process.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class sendGridEmailService implements EmailService{
//todo - make this a regular method by changing the name and giving it the parameters we want to pass in: subject, toEmail = to, content
    @Override
    public void sendEmailConfirmation(String custEmail, Order order) throws IOException {
        Email from = new Email("backrowboyzpizza@gmail.com");

        String subject = "Thanks for Ordering from Back Row Boyz Pizza!";
        Email to = new Email(custEmail);
        Content content = new Content("text/plain", order.toString());
        Mail mail = new Mail(from, subject, to, content);

        //This is the template I created online at https://mc.sendgrid.com/dynamic-templates :
        //        mail.setTemplateId("d-1a77882e59154014a3ca8870a98c3ff1");
        // it broke the basic text email though

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


/** this is a working version of the API as a main method:
 *
 *     public static void main(String[] args) throws IOException {
 *         Email from = new Email("backrowboyzpizza@gmail.com");
 *
 *         String subject = "This email is from our java server - test for sendGrid";
 *         Email to = new Email("matthewnowell97@gmail.com");
 *         Content content = new Content("text/plain", "Hi Matt, how does it feel to get an email from your backend server? Our external API call is working now. - Jonathan ");
 *         Mail mail = new Mail(from, subject, to, content);
 *
 *         //This is the template I created online at https://mc.sendgrid.com/dynamic-templates :
 *         //        mail.setTemplateId("d-1a77882e59154014a3ca8870a98c3ff1");
 *         // it broke the basic text email though
 *
 *         SendGrid sg = new SendGrid("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");
 *         Request request = new Request();
 *         try {
 *             request.setMethod(Method.POST);
 *             request.setEndpoint("mail/send");
 *             request.setBody(mail.build());
 *             Response response = sg.api(request);
 *             System.out.println(response.getStatusCode());
 *             System.out.println(response.getBody());
 *             System.out.println(response.getHeaders());
 *         } catch (IOException ex) {
 *             throw ex;
 *         }
 *     }
 *
 *
 * */



}
