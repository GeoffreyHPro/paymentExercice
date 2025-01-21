package exercice.payment.model;

import exercice.payment.utils.Currency;
import exercice.payment.utils.PaymentMeans;
import exercice.payment.utils.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPayment;

    private Double amount;

    private Currency currency;

    private PaymentMeans paymentMeans;

    private Status paymentStatus;

    public Payment(){
        this.paymentStatus = Status.IN_PROGRESS;
    }

}
