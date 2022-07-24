package ptithcm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;

@Service("mailer")
public class Mailer {
    @Autowired
    JavaMailSender mailer;

    public void send(String from, String to, String subject, String body) throws Exception {
        try {
            MimeMessage mail = mailer.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
            helper.setFrom(from, from);
            helper.setTo(to);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(body, true);

            mailer.send(mail);
        } catch (Exception e) {
            throw new Exception("An error has occured. Please check the SMTP server or if the email exist.");
        }
    }
}

