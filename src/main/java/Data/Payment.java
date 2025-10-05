package Data;

public class Payment {
    int paymentId;
    String paymentType;
    float amount;
    String status;

    public Payment(int paymentId, String paymentType, float amount, String status) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.status = status;
    }
}
