package hr.inforbis.bank.service.bank;

import hr.inforbis.bank.dao.bank.LoanContractDao;
import hr.inforbis.bank.dto.bank.LoanContract;
import hr.inforbis.bank.dto.bank.LoanPaymentPlan;
import hr.inforbis.bank.helpers.MathHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class LoanPlanGenerator {

    @Autowired
    LoanContractDao loanContractDao;

    LoanContract contract;

    public LoanContract generatePlan(LoanContract contract) {

        Double K = contract.getAmount().setScale(2).doubleValue();
        Double p = contract.getInterestRate().doubleValue();
        int n = contract.getTermYears().intValue()*12;
        Double a = 0.0;

        var r = (p / 100.0) * (1.0 / 12.0);

        a = Payment(K, r, n);

        Double i = 0.0;

        Double rK = K;

        LocalDate date = LocalDate.now();
        date = LocalDate.of(date.getYear(),date.getMonth(), date.getDayOfMonth());

        for(Double per=0.0;per<n;per++) {
             i = Interes(K, a, (p / 100.0) * (1.0 / 12.0), per);

            LoanPaymentPlan plan = new LoanPaymentPlan();
            plan.setDueDate(date);
            plan.setPaymentNo((int)(per + 1));
            plan.setPayment(MathHelpers.RoundDouble(a,2));
            plan.setInteres(MathHelpers.RoundDouble(i,2));
            plan.setBaseLoan(MathHelpers.RoundDouble(plan.getPayment()-plan.getInteres(),2));

            rK = MathHelpers.RoundDouble(rK - (a-i),2);

            if(rK<1.0) rK = 0.0;

            plan.setRestBalance(rK);

            contract.getPaymentPlan().add(plan);

            date = date.plusMonths(1);
        }

        loanContractDao.add(contract);


        return contract;
    }


    private Double Interes(Double K, Double a, Double rate, Double per) {
        var r = Math.pow(1.0 + rate, per);
        return (K * r * rate) - (a * (r - 1.0));
    }


    private Double Payment(Double K, Double rate, Integer n) {
        var r1 = Math.pow( 1.0 + rate, n);
        return rate / (r1 - 1.0) * (K * r1);
    }


}
