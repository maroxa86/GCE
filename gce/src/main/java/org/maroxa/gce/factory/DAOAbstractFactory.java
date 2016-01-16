package org.maroxa.gce.factory;

import org.maroxa.gce.factory.impl.DAOFactoryImpl;

public class DAOAbstractFactory {
    public static DAOFactory getInstance(){
        return new DAOFactoryImpl();
    }
}
