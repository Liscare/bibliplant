package fr.liscare;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Controller for Regulateur data
 *
 * @author Liscare
 */
@CrossOrigin
@RestController
public class DataRegulateurController {

    private final RegulateurService regulateurService;

    public DataRegulateurController(RegulateurService regulateurService) {
        this.regulateurService = regulateurService;
    }

    /**
     * Method GET
     *
     * @return All data
     */
    @GetMapping("/regulateurs")
    List<JSONObject> all() {
        return regulateurService.getAll();
    }

    /**
     * Methode GET
     *
     * @return All code with a ID
     */
    @GetMapping("/regulateurs/code")
    Map<Integer, String> get() {
        return regulateurService.getAllCode();
    }
}
