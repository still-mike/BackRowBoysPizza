package com.techelevator.services;
import com.sendgrid.*;
import java.io.IOException;


public class sendGridEmail implements email{
//todo - make this a regular method by changing the name and giving it the parameters we want to pass in: subject, to, content
    public static void main(String[] args) throws IOException {
        Email from = new Email("backrowboyzpizza@gmail.com");

        String subject = "after dynamic test - This email is from our java server - test for sendGrid";
        Email to = new Email("Jonathanpfettig@gmail.com");
        Content content = new Content("text/plain", "Hi Jonathan, how does it feel to get an email from your backend server? - Jonathan - test 3 bof the dynamic  ");
        Mail mail = new Mail(from, subject, to, content);

        //This is the template I created online at https://mc.sendgrid.com/dynamic-templates:
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


}
