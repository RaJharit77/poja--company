package com.company.demo.service.event;

import com.company.demo.endpoint.event.model.SendEmailRequested;
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
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {
    private final Mailer mailer;

    @SneakyThrows
    @Override
    public void accept(SendEmailRequested sendEmailRequested) {
        InternetAddress recipientAddress = new InternetAddress(sendEmailRequested.getTo());
        mailer.accept(new Email(recipientAddress, List.of(), List.of(), "", "... world!", List.of()));
    }
}
