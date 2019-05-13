package pl.org.schroeder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Validators {

    public static boolean isFinished;

    public static Map<Integer, Boolean> columnsConfig = new HashMap<>();

    private Validators() {
    }

    static {
        columnsConfig.put(1, true);
        columnsConfig.put(2, true);
        columnsConfig.put(3, false);
        columnsConfig.put(4, false);
        columnsConfig.put(5, false);
        columnsConfig.put(6, false);
        columnsConfig.put(7, false);
    }

    public static Set<Integer> getAvailableColumns () {

        return columnsConfig.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public static void disableColumn(Integer column) {

        columnsConfig.put(column, false);
    }
}
