package com.example.swagger2maekup_practic;

import io.swagger.models.Path;
import io.swagger.models.Swagger;

import java.util.*;

public class SortedSwagger extends Swagger{

    @Override
    public Map<String, Path> getPaths() {
        if (paths == null) {
            return null;
        }
        Map<String, Path> sorted = new LinkedHashMap<String, Path>();
        List<String> keys = new ArrayList<String>();
        keys.addAll(paths.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            sorted.put(key, paths.get(key));
            System.out.print(sorted);
        }
        return paths;
    }
}
