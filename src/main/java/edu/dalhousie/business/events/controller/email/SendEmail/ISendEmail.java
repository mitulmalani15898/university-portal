package edu.dalhousie.business.events.controller.email.SendEmail;

import edu.dalhousie.business.events.controller.email.Email;

public interface ISendEmail {
    public void sendEmail(String toEmail, Email email);
}
