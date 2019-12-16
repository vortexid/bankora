package hr.ibs.bank.api;


import hr.ibs.bank.dto.Kredit;
import hr.ibs.bank.service.KreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/kredit")
@RestController
public class KreditApi {

    @Autowired
    KreditService service;

    @GetMapping
    public List<Kredit> get() {
        List<Kredit> list = service.getList();
        return list;
    }


    @PostMapping
    public void kreiratiKredit(@RequestBody Zahtjev zahtjev) {

            service.kreiratiKredit(zahtjev.dospjece,
                    zahtjev.iznos,
                    zahtjev.kamata,
                    zahtjev.broj_godina);
    }


}
