package LLDPractice.Uber;

import LLDPractice.Uber.Enum.VehicleType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PricingService {
    private Map<VehicleType,Pricing> pricingMap = new HashMap<>();

    public PricingService(String configFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map<String, Integer>> rawData = mapper.readValue(new File(configFilePath), Map.class);
        for(Map.Entry<String, Map<String,Integer>> map: rawData.entrySet()){
            VehicleType type = VehicleType.valueOf(map.getKey());
            Pricing pricing = new Pricing(map.getValue().get("baseFare"), map.getValue().get("perKmPrice"));
            pricingMap.put(type, pricing);
        }
    }

    public Pricing getPricing(VehicleType vehicleType){
        return pricingMap.get(vehicleType);
    }
}
