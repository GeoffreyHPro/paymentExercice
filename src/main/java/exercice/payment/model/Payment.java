package exercice.payment.model;

import exercice.payment.exception.NulValueException;
import exercice.payment.exception.PaymentStatusException;

import java.util.List;

import exercice.payment.exception.NegativeValueException;
import exercice.payment.utils.Currency;
import exercice.payment.utils.PaymentMeans;
import exercice.payment.utils.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany
    private List<Command> listCommands;

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

    public void setAmount(Double amount) throws NegativeValueException, NulValueException {
        validateAmount(amount);
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setPaymentMeans(PaymentMeans paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) throws PaymentStatusException {
        paymentStatusIsValid(paymentStatus);
    }

    private void validateAmount(Double amount) throws NegativeValueException, NulValueException {
        if (amount < 0) {
            throw new NegativeValueException();
        }
        if (amount == 0) {
            throw new NulValueException();
        }
    }

    private void paymentStatusIsValid(PaymentStatus paymentStatus) throws PaymentStatusException {
        if (paymentStatus.equals(PaymentStatus.CAPTURED) &&
                this.paymentStatus.equals(PaymentStatus.AUTHORIZED)) {
            this.paymentStatus = paymentStatus;
        } else if (paymentStatus.equals(PaymentStatus.AUTHORIZED)
                && this.paymentStatus.equals(PaymentStatus.IN_PROGRESS)) {
            this.paymentStatus = paymentStatus;
        } else {
            throw new PaymentStatusException();
        }
    }

    public List<Command> getListCommands() {
        return listCommands;
    }

    public void setListCommands(List<Command> listCommands) {
        this.listCommands = listCommands;
    }

    public void addCommand(Command command) {
        this.listCommands.add(command);
    }
}
