package hr.ibs.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PlanOtplate extends BaseEntity {

    @Positive
    @NonNull
    Integer num;

    @NonNull
    Date dospjece;

    @Positive
    @NonNull
    Double anuitet;

    @Positive
    @NonNull
    Double kamata;

    @Positive
    @NonNull
    Double glavnica;

    @Positive
    @NonNull
    Double ostatak;

}

