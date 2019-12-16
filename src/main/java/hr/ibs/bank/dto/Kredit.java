package hr.ibs.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Kredit extends BaseEntity {

    @Positive
    Double iznos;
    @Positive
    Double kamata;
    @Positive
    Double broj_godina;
    @Positive
    Double anuitet;
    @Positive
    Double kamate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kredit_id")
    List<PlanOtplate> planOtplate = new ArrayList<>();

}
