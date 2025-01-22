package dev.srijit.BookMyShow.model;

import dev.srijit.BookMyShow.model.constant.PaymentMode;
import dev.srijit.BookMyShow.model.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}
/*
    Payment     Ticket
    1       ->   1
    M       <-   1

    Payment to Ticket -> M:1

    Ticket table
    TicketID
    T1
    T2
    T3

    Payment Table
    PaymentId   PaymentMode         TicketId        STATUS
    P1              UPI                 T1          FAILED
    P2              WALLET              T1          SUCCESS
    P3              CARD                T1          SUCCESS
 */