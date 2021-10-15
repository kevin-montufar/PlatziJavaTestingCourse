package co.com.devmont.javatestingcourse.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest paymentRequest);
}
