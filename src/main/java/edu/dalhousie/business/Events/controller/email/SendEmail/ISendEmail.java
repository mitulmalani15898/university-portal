package edu.dalhousie.business.Events.controller.email.SendEmail;

import edu.dalhousie.business.Events.controller.email.Email;

public interface ISendEmail {
    public void sendEmail(String toEmail, Email email);
}
