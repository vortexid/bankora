package hr.ibs.bank.api;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Zahtjev {

    String dospjece;
    Double iznos;
    Double kamata;
    Integer broj_godina;

}
