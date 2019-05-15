package pl.org.schroeder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Validators {

    public static Map<Integer, Boolean> columnsConfig = new HashMap<>();

    private Validators() {
    }

    static {
        columnsConfig.put(1, true);
        columnsConfig.put(2, true);
        columnsConfig.put(3, true);
        columnsConfig.put(4, true);
        columnsConfig.put(5, true);
        columnsConfig.put(6, true);
        columnsConfig.put(7, true);
    }

    public static Set<Integer> getAvailableColumns () {

        return columnsConfig.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public static void disableColumn(Integer column) {

        columnsConfig.put(column, false);
    }
}
