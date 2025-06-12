package com.company.demo.service.event;

import com.company.demo.endpoint.event.model.EmailUpdateTriggered;
import com.company.demo.mail.Email;
import com.company.demo.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailUpdateTriggeredService implements Consumer<EmailUpdateTriggered> {
  private final Mailer mailer;

  @SneakyThrows
  @Override
  public void accept(EmailUpdateTriggered emailUpdateTriggered) {
    var recipientAddress = new InternetAddress("your@email.com");
    mailer.accept(
        new Email(
            recipientAddress,
            List.of(),
            List.of(),
            "",
            "Here is your automatic daily email update !",
            List.of()));
  }
}
