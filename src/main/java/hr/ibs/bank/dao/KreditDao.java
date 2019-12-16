package hr.ibs.bank.dao;

import hr.ibs.bank.dto.Kredit;
import hr.ibs.bank.repo.KreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KreditDao extends CrudDaoImpl<Kredit> {

    @Autowired
    public KreditDao(KreditRepo repo) {
        this.repo = repo;
    }


    public void kreiratiKredit(String dospjece, Double iznos, Double kamata, Integer broj_godina) {
        ((KreditRepo)repo).calc_kredit(dospjece,iznos,kamata, broj_godina);
    }

}
