package com.techelevator.services;
import com.sendgrid.*;

public class sendGridDynamicEmailService {

    public static Mail buildDynamicTemplate() {
        Mail mail = new Mail();

        Email fromEmail = new Email();
        fromEmail.setName("BackRowBoyz Pizza");
        fromEmail.setEmail("backrowboyzpizza@gmail.com");
        mail.setFrom(fromEmail);


        Content content = new Content();
        content.setType("text/plain");
        content.setValue("some text here");
        mail.addContent(content);
//        content.setType("text/html");
//        content.setValue("<html><body>some text here</body></html>");
        mail.addContent(content);


        mail.setTemplateId("d-1a77882e59154014a3ca8870a98c3ff1");

        Personalization personalization = new Personalization();
//        personalization.addDynamicTemplateData("name", "Example User");
//        personalization.addDynamicTemplateData("city", "Denver");
        personalization.addTo(new Email("Jonathanpfettig@gmail.com"));
//        mail.addPersonalization(personalization);

        return mail;
    }


}
