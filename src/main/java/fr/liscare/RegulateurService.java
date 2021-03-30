package fr.liscare;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Service for Regulateur data
 * Seems to be repository
 *
 * @author Liscare
 */
@Service
public class RegulateurService {

    List<JSONObject> regulateurs = new ArrayList<>();

    public RegulateurService() {

    }

    /**
     * Load the JSON file (should be in json repository) and convert all data in JSONObject
     */
    public void loadFile() {
        Path file = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("json/regulateur.json")).getFile());
        try {
            JSONArray jsonArrayRegulateurs = new JSONArray(Files.readString(file));
            for (Object regulateur : jsonArrayRegulateurs) {
                regulateurs.add((JSONObject) regulateur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return All data
     */
    public List<JSONObject> getAll() {
        return regulateurs;
    }

    /**
     * @return Map of all code with a ID (from 0)
     */
    public Map<Integer, String> getAllCode() {
        HashMap<Integer, String> all = new HashMap<>();
        for (int id = 0 ; id < regulateurs.size() ; id++) {
            all.put(id, (String) regulateurs.get(id).get("Code"));
        }
        return all;
    }
}
