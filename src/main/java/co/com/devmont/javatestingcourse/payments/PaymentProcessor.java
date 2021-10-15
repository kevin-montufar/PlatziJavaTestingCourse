package co.com.devmont.javatestingcourse.payments;

import co.com.devmont.javatestingcourse.payments.enums.PaymentStatus;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        return paymentGateway.requestPayment(
                new PaymentRequest(amount)).getPaymentStatus().equals(PaymentStatus.OK
        );
    }
}
