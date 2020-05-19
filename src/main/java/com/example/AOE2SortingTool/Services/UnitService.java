package com.example.AOE2SortingTool.Services;
import com.example.AOE2SortingTool.Model.Unit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author robertsonje
 */
@Service
public class UnitService {
    private List<Unit> units;
    public List<Unit> findByUnitName(String name) {
        List<Unit> result;
        result = units.stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        java.util.Collections.sort(result);
        return result;
    }
    
    @PostConstruct
    private void initializeApiData() {
        final String uri = "https://age-of-empires-2-api.herokuapp.com/api/v1/units";

        units = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(result);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UnitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        parseJsonForUnitList(node);
    }
    
    private void parseJsonForUnitList(JsonNode unitJson) {
        if (unitJson != null) {
            JsonNode unitList = unitJson.get("units");
            JsonNode currentUnit = null;
            int i = 0;
            while (unitList.has(i)) {
                currentUnit = unitList.get(i);
                                
                // Parse by field
                units.add(new Unit(currentUnit));
                i++;
            }
        }
    }
}
