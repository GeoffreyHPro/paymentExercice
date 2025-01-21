package exercice.payment.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercice.payment.exception.NegativeValueException;
import exercice.payment.exception.PaymentStatusException;
import exercice.payment.utils.PaymentStatus;

public class PaymentTest {
    private Payment payment;

    @BeforeEach
    public void setUp() {
        this.payment = new Payment();
    }

    @Test
    public void testPaymentConstructor() {
        assertEquals(PaymentStatus.IN_PROGRESS, this.payment.getPaymentStatus());
    }

    @Test
    public void testPaymentStatusSuccess() throws PaymentStatusException {
        this.payment.setPaymentStatus(PaymentStatus.AUTHORIZED);
        assertEquals(PaymentStatus.AUTHORIZED, this.payment.getPaymentStatus());
        this.payment.setPaymentStatus(PaymentStatus.CAPTURED);
        assertEquals(PaymentStatus.CAPTURED, this.payment.getPaymentStatus());
    }

    @Test
    public void testPaymentStatusThrowException() throws PaymentStatusException {
        assertThrows(PaymentStatusException.class, () -> {
            this.payment.setPaymentStatus(PaymentStatus.CAPTURED);
            this.payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
        });

        this.payment.setPaymentStatus(PaymentStatus.AUTHORIZED);

        assertThrows(PaymentStatusException.class, () -> {
            this.payment.setPaymentStatus(PaymentStatus.AUTHORIZED);
            this.payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
        });

        this.payment.setPaymentStatus(PaymentStatus.CAPTURED);

        assertThrows(PaymentStatusException.class, () -> {
            this.payment.setPaymentStatus(PaymentStatus.CAPTURED);
            this.payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
            this.payment.setPaymentStatus(PaymentStatus.AUTHORIZED);
        });
    }

}
