package co.com.devmont.javatestingcourse.payments;

import co.com.devmont.javatestingcourse.payments.enums.PaymentStatus;

public class PaymentResponse {
    private PaymentStatus paymentStatus;

    public PaymentResponse(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
