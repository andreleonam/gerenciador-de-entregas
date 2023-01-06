package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.*;
import com.premic.gerenciadorDeEntregas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private PublicPlaceRepository publicPlaceRepository;

    @Autowired
    private StateRepository stateRepository;

   /* @Autowired
    private CityRepository cityRepository;*/

    public void instantiateTestDatabase() {

        Category cat01 = new Category(null, "BANCO CONCRETO");
        Category cat02 = new Category(null, "BLOCO CIMENTO");
        Category cat03 = new Category(null, "CAIXA CONCRETO");
        Category cat04 = new Category(null, "CALHA CIMENTO");
        Category cat05 = new Category(null, "COBOGO CIMENTO");
        Category cat06 = new Category(null, "ESCADA HELICOIDAL CONCRETO");
        Category cat07 = new Category(null, "LAJOTA");
        Category cat08 = new Category(null, "MEIO FIO CONCRETO");
        Category cat09 = new Category(null, "MOURAO CONCRETO");
        Category cat10 = new Category(null, "PE DIREITO CONCRETO");
        Category cat11 = new Category(null, "PERGOLA CONCRETO");
        Category cat12 = new Category(null, "PISO CIMENTO");
        Category cat13 = new Category(null, "PLACA CONCRETO");
        Category cat14 = new Category(null, "VIGA CONCRETO TR12645 TG12M");
        Category cat15 = new Category(null, "VIGA CONCRETO TR12646 TG12R");
        Category cat16 = new Category(null, "VIGA CONCRETO TR16745 TG16L");
        Category cat17 = new Category(null, "VIGA CONCRETO TR16746 TG16R");
        Category cat18 = new Category(null, "VIGA CONCRETO TR20745 TG20L");
        Category cat19 = new Category(null, "VIGA CONCRETO TR20756 TG20R");
        Category cat20 = new Category(null, "VIGA CONCRETO TR25856 TG25L");
        Category cat21 = new Category(null, "VIGA CONCRETO TR25857 TG25R");
        Category cat22 = new Category(null, "TUBO CONCRETO");
        Category cat23 = new Category(null, "VIGA CONCRETO");
        Category cat24 = new Category(null, "VIGA CONCRETO TR08644 TG08L");
        Category cat25 = new Category(null, "VIGA CONCRETO TR08645 TG08M");
        categoryRepository.saveAll(Arrays.asList(cat01, cat02, cat03, cat04, cat05, cat06, cat07, cat08, cat09, cat10, cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20, cat21, cat22, cat23, cat24, cat25));


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

        PublicPlace pp001 = new PublicPlace(null, "A", "Área");
        PublicPlace pp002 = new PublicPlace(null, "AC", "Acesso");
        PublicPlace pp003 = new PublicPlace(null, "ACA", "Acampamento");
        PublicPlace pp004 = new PublicPlace(null, "ACL", "Acesso Local");
        PublicPlace pp005 = new PublicPlace(null, "AD", "Adro");
        PublicPlace pp006 = new PublicPlace(null, "AE", "Área Especial");
        PublicPlace pp007 = new PublicPlace(null, "AER", "Aeroporto");
        PublicPlace pp008 = new PublicPlace(null, "AL", "Alameda");
        PublicPlace pp009 = new PublicPlace(null, "AMD", "Avenida Marginal Direita");
        PublicPlace pp010 = new PublicPlace(null, "AME", "Avenida Marginal Esquerda");
        PublicPlace pp011 = new PublicPlace(null, "AN", "Anel Viário");
        PublicPlace pp012 = new PublicPlace(null, "ANT", "Antiga Estrada");
        PublicPlace pp013 = new PublicPlace(null, "ART", "Artéria");
        PublicPlace pp014 = new PublicPlace(null, "AT", "Alto");
        PublicPlace pp015 = new PublicPlace(null, "ATL", "Atalho");
        PublicPlace pp016 = new PublicPlace(null, "A V", "Área Verde");
        PublicPlace pp017 = new PublicPlace(null, "AV", "Avenida");
        PublicPlace pp018 = new PublicPlace(null, "AVC", "Avenida Contorno");
        PublicPlace pp019 = new PublicPlace(null, "AVM", "Avenida Marginal");
        PublicPlace pp020 = new PublicPlace(null, "AVV", "Avenida Velha");
        PublicPlace pp021 = new PublicPlace(null, "BAL", "Balneário");
        PublicPlace pp022 = new PublicPlace(null, "BC", "Beco");
        PublicPlace pp023 = new PublicPlace(null, "BCO", "Buraco");
        PublicPlace pp024 = new PublicPlace(null, "BEL", "Belvedere");
        PublicPlace pp025 = new PublicPlace(null, "BL", "Bloco");
        PublicPlace pp026 = new PublicPlace(null, "BLO", "Balão");
        PublicPlace pp027 = new PublicPlace(null, "BLS", "Blocos");
        PublicPlace pp028 = new PublicPlace(null, "BLV", "Bulevar");
        PublicPlace pp029 = new PublicPlace(null, "BSQ", "Bosque");
        PublicPlace pp030 = new PublicPlace(null, "BVD", "Boulevard");
        PublicPlace pp031 = new PublicPlace(null, "BX", "Baixa");
        PublicPlace pp032 = new PublicPlace(null, "C", "Cais");
        PublicPlace pp033 = new PublicPlace(null, "CAL", "Calçada");
        PublicPlace pp034 = new PublicPlace(null, "CAM", "Caminho");
        PublicPlace pp035 = new PublicPlace(null, "CAN", "Canal");
        PublicPlace pp036 = new PublicPlace(null, "CH", "Chácara");
        PublicPlace pp037 = new PublicPlace(null, "CHA", "Chapadão");
        PublicPlace pp038 = new PublicPlace(null, "CIC", "Ciclovia");
        PublicPlace pp039 = new PublicPlace(null, "CIR", "Circular");
        PublicPlace pp040 = new PublicPlace(null, "CJ", "Conjunto");
        PublicPlace pp041 = new PublicPlace(null, "CJM", "Conjunto Mutirão");
        PublicPlace pp042 = new PublicPlace(null, "CMP", "Complexo Viário");
        PublicPlace pp043 = new PublicPlace(null, "COL", "Colônia");
        PublicPlace pp044 = new PublicPlace(null, "COM", "Comunidade");
        PublicPlace pp045 = new PublicPlace(null, "CON", "Condomínio");
        PublicPlace pp046 = new PublicPlace(null, "COR", "Corredor");
        PublicPlace pp047 = new PublicPlace(null, "CPO", "Campo");
        PublicPlace pp048 = new PublicPlace(null, "CRG", "Córrego");
        PublicPlace pp049 = new PublicPlace(null, "CTN", "Contorno");
        PublicPlace pp050 = new PublicPlace(null, "DSC", "Descida");
        PublicPlace pp051 = new PublicPlace(null, "DSV", "Desvio");
        PublicPlace pp052 = new PublicPlace(null, "DT", "Distrito");
        PublicPlace pp053 = new PublicPlace(null, "EB", "Entre Bloco");
        PublicPlace pp054 = new PublicPlace(null, "EIM", "Estrada Intermunicipal");
        PublicPlace pp055 = new PublicPlace(null, "ENS", "Enseada");
        PublicPlace pp056 = new PublicPlace(null, "ENT", "Entrada Particular");
        PublicPlace pp057 = new PublicPlace(null, "EQ", "Entre Quadra");
        PublicPlace pp058 = new PublicPlace(null, "ESC", "Escada");
        PublicPlace pp059 = new PublicPlace(null, "ESD", "Escadaria");
        PublicPlace pp060 = new PublicPlace(null, "ESE", "Estrada Estadual");
        PublicPlace pp061 = new PublicPlace(null, "ESI", "Estrada Vicinal");
        PublicPlace pp062 = new PublicPlace(null, "ESL", "Estrada de Ligação");
        PublicPlace pp063 = new PublicPlace(null, "ESM", "Estrada Municipal");
        PublicPlace pp064 = new PublicPlace(null, "ESP", "Esplanada");
        PublicPlace pp065 = new PublicPlace(null, "ESS", "Estrada de Servidão");
        PublicPlace pp066 = new PublicPlace(null, "EST", "Estrada");
        PublicPlace pp067 = new PublicPlace(null, "ESV", "Estrada Velha");
        PublicPlace pp068 = new PublicPlace(null, "ETA", "Estrada Antiga");
        PublicPlace pp069 = new PublicPlace(null, "ETC", "Estação");
        PublicPlace pp070 = new PublicPlace(null, "ETD", "Estádio");
        PublicPlace pp071 = new PublicPlace(null, "ETN", "Estância");
        PublicPlace pp072 = new PublicPlace(null, "ETP", "Estrada Particular");
        PublicPlace pp073 = new PublicPlace(null, "ETT", "Estacionamento");
        PublicPlace pp074 = new PublicPlace(null, "EVA", "Evangélica");
        PublicPlace pp075 = new PublicPlace(null, "EVD", "Elevada");
        PublicPlace pp076 = new PublicPlace(null, "EX", "Eixo Industrial");
        PublicPlace pp077 = new PublicPlace(null, "FAV", "Favela");
        PublicPlace pp078 = new PublicPlace(null, "FAZ", "Fazenda");
        PublicPlace pp079 = new PublicPlace(null, "FER", "Ferrovia");
        PublicPlace pp080 = new PublicPlace(null, "FNT", "Fonte");
        PublicPlace pp081 = new PublicPlace(null, "FRA", "Feira");
        PublicPlace pp082 = new PublicPlace(null, "FTE", "Forte");
        PublicPlace pp083 = new PublicPlace(null, "GAL", "Galeria");
        PublicPlace pp084 = new PublicPlace(null, "GJA", "Granja");
        PublicPlace pp085 = new PublicPlace(null, "HAB", "Núcleo Habitacional");
        PublicPlace pp086 = new PublicPlace(null, "IA", "Ilha");
        PublicPlace pp087 = new PublicPlace(null, "IND", "Indeterminado");
        PublicPlace pp088 = new PublicPlace(null, "IOA", "Ilhota");
        PublicPlace pp089 = new PublicPlace(null, "JD", "Jardim");
        PublicPlace pp090 = new PublicPlace(null, "JDE", "Jardinete");
        PublicPlace pp091 = new PublicPlace(null, "LD", "Ladeira");
        PublicPlace pp092 = new PublicPlace(null, "LGA", "Lagoa");
        PublicPlace pp093 = new PublicPlace(null, "LGO", "Lago");
        PublicPlace pp094 = new PublicPlace(null, "LOT", "Loteamento");
        PublicPlace pp095 = new PublicPlace(null, "LRG", "Largo");
        PublicPlace pp096 = new PublicPlace(null, "LT", "Lote");
        PublicPlace pp097 = new PublicPlace(null, "MER", "Mercado");
        PublicPlace pp098 = new PublicPlace(null, "MNA", "Marina");
        PublicPlace pp099 = new PublicPlace(null, "MOD", "Modulo");
        PublicPlace pp100 = new PublicPlace(null, "MRG", "Projeção");
        PublicPlace pp101 = new PublicPlace(null, "MRO", "Morro");
        PublicPlace pp102 = new PublicPlace(null, "MTE", "Monte");
        PublicPlace pp103 = new PublicPlace(null, "NUC", "Núcleo");
        PublicPlace pp104 = new PublicPlace(null, "NUR", "Núcleo Rural");
        PublicPlace pp105 = new PublicPlace(null, "OUT", "Outeiro");
        PublicPlace pp106 = new PublicPlace(null, "PAR", "Paralela");
        PublicPlace pp107 = new PublicPlace(null, "PAS", "Passeio");
        PublicPlace pp108 = new PublicPlace(null, "PAT", "Pátio");
        PublicPlace pp109 = new PublicPlace(null, "PC", "Praça");
        PublicPlace pp110 = new PublicPlace(null, "PCE", "Praça de Esportes");
        PublicPlace pp111 = new PublicPlace(null, "PDA", "Parada");
        PublicPlace pp112 = new PublicPlace(null, "PDO", "Paradouro");
        PublicPlace pp113 = new PublicPlace(null, "PNT", "Ponta");
        PublicPlace pp114 = new PublicPlace(null, "PR", "Praia");
        PublicPlace pp115 = new PublicPlace(null, "PRL", "Prolongamento");
        PublicPlace pp116 = new PublicPlace(null, "PRM", "Parque Municipal");
        PublicPlace pp117 = new PublicPlace(null, "PRQ", "Parque");
        PublicPlace pp118 = new PublicPlace(null, "PRR", "Parque Residencial");
        PublicPlace pp119 = new PublicPlace(null, "PSA", "Passarela");
        PublicPlace pp120 = new PublicPlace(null, "PSG", "Passagem");
        PublicPlace pp121 = new PublicPlace(null, "PSP", "Passagem de Pedestre");
        PublicPlace pp122 = new PublicPlace(null, "PSS", "Passagem Subterrânea");
        PublicPlace pp123 = new PublicPlace(null, "PTE", "Ponte");
        PublicPlace pp124 = new PublicPlace(null, "PTO", "Porto");
        PublicPlace pp125 = new PublicPlace(null, "Q", "Quadra");
        PublicPlace pp126 = new PublicPlace(null, "QTA", "Quinta");
        PublicPlace pp127 = new PublicPlace(null, "QTS", "Quintas");
        PublicPlace pp128 = new PublicPlace(null, "R", "Rua");
        PublicPlace pp129 = new PublicPlace(null, "R I", "Rua Integração");
        PublicPlace pp130 = new PublicPlace(null, "R L", "Rua de Ligação");
        PublicPlace pp131 = new PublicPlace(null, "R P", "Rua Particular");
        PublicPlace pp132 = new PublicPlace(null, "R V", "Rua Velha");
        PublicPlace pp133 = new PublicPlace(null, "RAM", "Ramal");
        PublicPlace pp134 = new PublicPlace(null, "RCR", "Recreio");
        PublicPlace pp135 = new PublicPlace(null, "REC", "Recanto");
        PublicPlace pp136 = new PublicPlace(null, "RER", "Retiro");
        PublicPlace pp137 = new PublicPlace(null, "RES", "Residencial");
        PublicPlace pp138 = new PublicPlace(null, "RET", "Reta");
        PublicPlace pp139 = new PublicPlace(null, "RLA", "Ruela");
        PublicPlace pp140 = new PublicPlace(null, "RMP", "Rampa");
        PublicPlace pp141 = new PublicPlace(null, "ROA", "Rodo Anel");
        PublicPlace pp142 = new PublicPlace(null, "ROD", "Rodovia");
        PublicPlace pp143 = new PublicPlace(null, "ROT", "Rotula");
        PublicPlace pp144 = new PublicPlace(null, "RPE", "Rua de Pedestre");
        PublicPlace pp145 = new PublicPlace(null, "RPR", "Margem");
        PublicPlace pp146 = new PublicPlace(null, "RTN", "Retorno");
        PublicPlace pp147 = new PublicPlace(null, "RTT", "Rotatória");
        PublicPlace pp148 = new PublicPlace(null, "SEG", "Segunda Avenida");
        PublicPlace pp149 = new PublicPlace(null, "SIT", "Sitio");
        PublicPlace pp150 = new PublicPlace(null, "SRV", "Servidão");
        PublicPlace pp151 = new PublicPlace(null, "ST", "Setor");
        PublicPlace pp152 = new PublicPlace(null, "SUB", "Subida");
        PublicPlace pp153 = new PublicPlace(null, "TCH", "Trincheira");
        PublicPlace pp154 = new PublicPlace(null, "TER", "Terminal");
        PublicPlace pp155 = new PublicPlace(null, "TR", "Trecho");
        PublicPlace pp156 = new PublicPlace(null, "TRV", "Trevo");
        PublicPlace pp157 = new PublicPlace(null, "TUN", "Túnel");
        PublicPlace pp158 = new PublicPlace(null, "TV", "Travessa");
        PublicPlace pp159 = new PublicPlace(null, "TVP", "Travessa Particular");
        PublicPlace pp160 = new PublicPlace(null, "TVV", "Travessa Velha");
        PublicPlace pp161 = new PublicPlace(null, "UNI", "Unidade");
        PublicPlace pp162 = new PublicPlace(null, "V", "Via");
        PublicPlace pp163 = new PublicPlace(null, "V C", "Via Coletora");
        PublicPlace pp164 = new PublicPlace(null, "V L", "Via Local");
        PublicPlace pp165 = new PublicPlace(null, "VAC", "Via de Acesso");
        PublicPlace pp166 = new PublicPlace(null, "VAL", "Vala");
        PublicPlace pp167 = new PublicPlace(null, "VCO", "Via Costeira");
        PublicPlace pp168 = new PublicPlace(null, "VD", "Viaduto");
        PublicPlace pp169 = new PublicPlace(null, "V-E", "Via Expressa");
        PublicPlace pp170 = new PublicPlace(null, "VER", "Vereda");
        PublicPlace pp171 = new PublicPlace(null, "VEV", "Via Elevado");
        PublicPlace pp172 = new PublicPlace(null, "VL", "Vila");
        PublicPlace pp173 = new PublicPlace(null, "VLA", "Viela");
        PublicPlace pp174 = new PublicPlace(null, "VLE", "Vale");
        PublicPlace pp175 = new PublicPlace(null, "VLT", "Via Litorânea");
        PublicPlace pp176 = new PublicPlace(null, "VPE", "Via de Pedestre");
        PublicPlace pp177 = new PublicPlace(null, "VRT", "Variante");
        PublicPlace pp178 = new PublicPlace(null, "ZIG", "Zigue-Zague");
        publicPlaceRepository.saveAll(Arrays.asList(pp001, pp002, pp003, pp004, pp005, pp006, pp007, pp008, pp009, pp010, pp011, pp012, pp013, pp014, pp015, pp016, pp017, pp018, pp019, pp020, pp021, pp022, pp023, pp024, pp025, pp026, pp027, pp028, pp029, pp030, pp031, pp032, pp033, pp034, pp035, pp036, pp037, pp038, pp039, pp040, pp041, pp042, pp043, pp044, pp045, pp046, pp047, pp048, pp049, pp050, pp051, pp052, pp053, pp054, pp055, pp056, pp057, pp058, pp059, pp060, pp061, pp062, pp063, pp064, pp065, pp066, pp067, pp068, pp069, pp070, pp071, pp072, pp073, pp074, pp075, pp076, pp077, pp078, pp079, pp080, pp081, pp082, pp083, pp084, pp085, pp086, pp087, pp088, pp089, pp090, pp091, pp092, pp093, pp094, pp095, pp096, pp097, pp098, pp099, pp100, pp101, pp102, pp103, pp104, pp105, pp106, pp107, pp108, pp109, pp110, pp111, pp112, pp113, pp114, pp115, pp116, pp117, pp118, pp119, pp120, pp121, pp122, pp123, pp124, pp125, pp126, pp127, pp128, pp129, pp130, pp131, pp132, pp133, pp134, pp135, pp136, pp137, pp138, pp139, pp140, pp141, pp142, pp143, pp144, pp145, pp146, pp147, pp148, pp149, pp150, pp151, pp152, pp153, pp154, pp155, pp156, pp157, pp158, pp159, pp160, pp161, pp162, pp163, pp164, pp165, pp166, pp167, pp168, pp169, pp170, pp171, pp172, pp173, pp174, pp175, pp176, pp177, pp178));


        State st01 = new State(null, "SE", "Sergipe");
        State st02 = new State(null, "AL", "Alagoas");
        stateRepository.saveAll(Arrays.asList(st01, st02));

       /* City ct01 = new City(null, "Aracaju", st01);
        City ct02 = new City(null, "Maceió", st02);
        City ct03 = new City(null, "Laranjeiras", st01);
        cityRepository.saveAll(Arrays.asList(ct01, ct02, ct03));*/
    }
}