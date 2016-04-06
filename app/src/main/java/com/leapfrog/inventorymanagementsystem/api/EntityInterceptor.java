package com.leapfrog.inventorymanagementsystem.api;

/**
 */
public class EntityInterceptor {
    static volatile EntityInterceptor entityInterceptor;

    private EntityInterceptor() {

    }

    public static EntityInterceptor getInstance() {
        if (entityInterceptor == null) {
            synchronized (EntityInterceptor.class) {
                if (entityInterceptor == null)
                    entityInterceptor = new EntityInterceptor();
            }
        }
        return entityInterceptor;
    }


}
