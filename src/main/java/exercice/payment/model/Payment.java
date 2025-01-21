package exercice.payment.model;

import exercice.payment.utils.Currency;
import exercice.payment.utils.PaymentMeans;
import exercice.payment.utils.PaymentStatus;
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

    private PaymentStatus paymentStatus;

    public Payment() {
        this.paymentStatus = PaymentStatus.IN_PROGRESS;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public PaymentMeans getPaymentMeans() {
        return paymentMeans;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setPaymentMeans(PaymentMeans paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
