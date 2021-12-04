package edu.dalhousie.business.DalMembership.controller.services;

import edu.dalhousie.business.DalMembership.controller.inMemoryDatabase.MasterDB;

public class Services implements IServices{
    @Override
    public void getListOfServices() {
        MasterDB.servicesMap.keySet().stream().forEach(membership->{
            System.out.println("Services available under " + membership.name() +" plan:" );
            System.out.println("===========================");
            MasterDB.servicesMap.get(membership).stream().forEach(service->{
                System.out.println("Name: "+ service.name() + " price: "+ service.price +" CAD" );
            });
            System.out.println("");
        });
    }
}
