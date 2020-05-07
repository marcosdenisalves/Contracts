package model.services;

import java.util.Calendar;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	private static Calendar cal = Calendar.getInstance();
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {

		double installment = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, i);
			contract.getInstallment().add(new Installment(cal.getTime(), onlinePaymentService.paymentFee(onlinePaymentService.interest(installment, i))));
		}
	}
}
