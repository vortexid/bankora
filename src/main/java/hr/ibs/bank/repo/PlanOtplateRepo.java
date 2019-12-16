package hr.ibs.bank.repo;

import hr.ibs.bank.dto.PlanOtplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanOtplateRepo extends CrudRepository<PlanOtplate,Long> {
}
