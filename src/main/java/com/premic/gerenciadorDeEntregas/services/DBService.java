package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.Category;
import com.premic.gerenciadorDeEntregas.entities.Unit;
import com.premic.gerenciadorDeEntregas.repositories.CategoryRepository;
import com.premic.gerenciadorDeEntregas.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitRepository unitRepository;

    public void instantiateTestDatabase() {

        Category cat01 = new Category(null,"BANCO CONCRETO");
        Category cat02 = new Category(null,"BLOCO CIMENTO");
        Category cat03 = new Category(null,"CAIXA CONCRETO");
        Category cat04 = new Category(null,"CALHA CIMENTO");
        Category cat05 = new Category(null,"COBOGO CIMENTO");
        Category cat06 = new Category(null,"ESCADA HELICOIDAL CONCRETO");
        Category cat07 = new Category(null,"LAJOTA");
        Category cat08 = new Category(null,"MEIO FIO CONCRETO");
        Category cat09 = new Category(null,"MOURAO CONCRETO");
        Category cat10 = new Category(null,"PE DIREITO CONCRETO");
        Category cat11 = new Category(null,"PERGOLA CONCRETO");
        Category cat12 = new Category(null,"PISO CIMENTO");
        Category cat13 = new Category(null,"PLACA CONCRETO");
        Category cat14 = new Category(null,"VIGA CONCRETO TR12645 TG12M");
        Category cat15 = new Category(null,"VIGA CONCRETO TR12646 TG12R");
        Category cat16 = new Category(null,"VIGA CONCRETO TR16745 TG16L");
        Category cat17 = new Category(null,"VIGA CONCRETO TR16746 TG16R");
        Category cat18 = new Category(null,"VIGA CONCRETO TR20745 TG20L");
        Category cat19 = new Category(null,"VIGA CONCRETO TR20756 TG20R");
        Category cat20 = new Category(null,"VIGA CONCRETO TR25856 TG25L");
        Category cat21 = new Category(null,"VIGA CONCRETO TR25857 TG25R");
        Category cat22 = new Category(null,"TUBO CONCRETO");
        Category cat23 = new Category(null,"VIGA CONCRETO");
        Category cat24 = new Category(null,"VIGA CONCRETO TR08644 TG08L");
        Category cat25 = new Category(null,"VIGA CONCRETO TR08645 TG08M");
        categoryRepository.saveAll(Arrays.asList(cat01,	cat02,	cat03,	cat04,	cat05,	cat06,	cat07,	cat08,	cat09,	cat10,	cat11,	cat12,	cat13,	cat14,	cat15,	cat16,	cat17,	cat18,	cat19,	cat20,	cat21,	cat22,	cat23,	cat24,	cat25));


        Unit u01 = new Unit(null, "%", "CENTO");
        Unit u02 = new Unit(null, "@", "ARROBA");
        Unit u03 = new Unit(null, "CX", "CAIXA");
        Unit u04 = new Unit(null, "DZ", "DÚZIA");
        Unit u05 = new Unit(null, "FD", "FARDO");
        Unit u06 = new Unit(null, "GL", "GALAO");
        Unit u07 = new Unit(null, "KG", "QUILOGRAMA");
        Unit u08 = new Unit(null, "L", "LITRO");
        Unit u09 = new Unit(null, "LT", "LATA");
        Unit u10 = new Unit(null, "M", "METRO");
        Unit u11 = new Unit(null, "M2", "METRO QUADRADO");
        Unit u12 = new Unit(null, "M3", "METRO CÚBICO");
        Unit u13 = new Unit(null, "MIL", "MILHEIRO");
        Unit u14 = new Unit(null, "PC", "PEÇA");
        Unit u15 = new Unit(null, "RL", "ROLO");
        Unit u16 = new Unit(null, "SC", "SACO");
        Unit u17 = new Unit(null, "T", "TONELADA");
        Unit u18 = new Unit(null, "UN", "UNIDADE");
        unitRepository.saveAll(Arrays.asList(u01, u02, u03, u04, u05, u06, u07, u08, u09, u10, u11, u12, u13, u14, u15, u16, u17, u18));

    }
}