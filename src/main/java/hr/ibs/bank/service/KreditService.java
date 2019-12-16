package hr.ibs.bank.service;

import hr.ibs.bank.dao.KreditDao;
import hr.ibs.bank.dto.Kredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KreditService extends DataService<Kredit>  {

    @Autowired
    public void KreditService(KreditDao dao) {
        this.dao = dao;
    }

    public void kreiratiKredit(String dospjece, Double iznos, Double kamata, Integer broj_godina) {
        ((KreditDao)dao).kreiratiKredit(dospjece,iznos,kamata, broj_godina);
    }

}
