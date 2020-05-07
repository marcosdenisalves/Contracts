package model.services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public double interest(double amount, int months) {
		return amount + (amount * 1 / 100) * months;
	}

	@Override
	public double paymentFee(double amount) {
		return amount + (amount * 2 / 100);
	}

}
