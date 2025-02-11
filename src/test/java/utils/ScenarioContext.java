package utils;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static Map<String, Object> scenarioData = new HashMap<>();

    public static void set(String key, Object value) {
        scenarioData.put(key, value);
    }

    public static Object get(String key) {
        return scenarioData.get(key);
    }

    public static void clear() {
        scenarioData.clear();
    }
}


