package hr.ibs.bank;


import hr.ibs.bank.api.Zahtjev;
import hr.ibs.bank.service.LoanPlanGenerator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class calcLoanTest {

    @Test
    public void runTest() {

        LoanPlanGenerator gen = new LoanPlanGenerator();

        Zahtjev contract = new Zahtjev();

        contract.setIznos(100000.0);
        contract.setKamata(5.0);
        contract.setBroj_godina(5);
        contract.setDospjece("2019-01-15");

        gen.generatePlan(contract);

    }
}