package exercice.payment.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
