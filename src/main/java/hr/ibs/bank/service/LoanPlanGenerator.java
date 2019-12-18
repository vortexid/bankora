package hr.ibs.bank.service;

import hr.ibs.bank.api.Zahtjev;
import hr.ibs.bank.dao.KreditDao;
import hr.ibs.bank.dto.Kredit;
import hr.ibs.bank.dto.PlanOtplate;
import hr.ibs.bank.helpers.MathHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class LoanPlanGenerator {

    @Autowired
    KreditDao loanContractDao;

    Kredit contract;

    public Kredit generatePlan(Zahtjev contract) {

        Double K = contract.getIznos();
        Double p = contract.getKamata();
        int n = contract.getBroj_godina() *12;
        Double a = 0.0;

        Double r = (p / 100.0) * (1.0 / 12.0);

        a = Payment(K, r, n);

        Double i = 0.0;
        Kredit kredit = new Kredit();
        Double kamate = 0.0;

        kredit.setAnuitet(a);
        kredit.setBroj_godina(contract.getBroj_godina().doubleValue());
        kredit.setIznos(contract.getIznos());
        kredit.setKamata(p);

        Double rK = K;

        LocalDate date = LocalDate.now();
        date = LocalDate.of(date.getYear(),date.getMonth(), date.getDayOfMonth());

        for(Double per=0.0;per<n;per++) {

            i = Interes(K, a, (p / 100.0) * (1.0 / 12.0), per);

            PlanOtplate plan = new PlanOtplate();
            plan.setDospjece(date);
            plan.setNum(per.intValue() + 1);
            plan.setAnuitet(MathHelpers.RoundDouble(a,2));
            plan.setKamata(MathHelpers.RoundDouble(i,2));
            plan.setGlavnica(MathHelpers.RoundDouble(plan.getAnuitet()-plan.getKamata(),2));

            rK = MathHelpers.RoundDouble(rK - (a-i),2);

            if(rK<1.0) rK = 0.0;

            plan.setOstatak(rK);

            kredit.getPlanOtplate().add(plan);

            date = date.plusMonths(1);

            kamate += MathHelpers.RoundDouble(i,2);

            kredit.getPlanOtplate().add(plan);
        }

        kredit.setKamate(kamate);

        return kredit;
    }


    private Double Interes(Double K, Double a, Double rate, Double per) {
        Double r = Math.pow(1.0 + rate, per);
        return (K * r * rate) - (a * (r - 1.0));
    }


    private Double Payment(Double K, Double rate, Integer n) {
        Double r1 = Math.pow( 1.0 + rate, n);
        return rate / (r1 - 1.0) * (K * r1);
    }


}
