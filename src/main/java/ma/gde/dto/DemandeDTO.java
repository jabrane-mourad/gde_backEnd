package ma.gde.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.enun.TypeDemande;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDTO {
    private TypeDemande typeDemande;
    private String description;
    private String codeMasar;
}
