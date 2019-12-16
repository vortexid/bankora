package hr.ibs.bank.repo;

import hr.ibs.bank.dto.Kredit;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KreditRepo extends CrudRepository<Kredit,Long> {

@Procedure(name="CALC_KREDIT")
public void calc_kredit(@Param("dosp_uplate") String dosp_uplate,
                           @Param("iznos_kredita") Double iznos_kredita,
                           @Param("kamatna_stopa") Double kamatna_stopa,
                           @Param("broj_godina") Integer broj_godina);

}
