package br.ufc.comp.qalc;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ResourcesManager {
    private static Set<Closeable> managedCloseables = new HashSet<>();

    public static void manage(Closeable resource) {
        managedCloseables.add(resource);
    }

    public static boolean yield(Closeable resource) {
        return managedCloseables.remove(resource);
    }

    public static long shutdown(boolean printStackTrace) {
        long failed = 0;

        for(Closeable resource : managedCloseables) {
            try {
                resource.close();
            } catch (IOException e) {
                ++failed;

                if(printStackTrace) {
                    e.printStackTrace();
                }
            }
        }

        return failed;
    }
}
