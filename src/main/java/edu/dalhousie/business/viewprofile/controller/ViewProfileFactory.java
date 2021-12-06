package edu.dalhousie.business.viewprofile.controller;

import edu.dalhousie.business.viewprofile.database.IUpdateProfileConnection;
import edu.dalhousie.business.viewprofile.database.IViewProfileConnection;
import edu.dalhousie.business.viewprofile.database.UpdateProfileConnection;
import edu.dalhousie.business.viewprofile.database.ViewProfileConnection;
import edu.dalhousie.business.viewprofile.model.IViewProfileModel;
import edu.dalhousie.business.viewprofile.model.ViewProfileModel;

public class ViewProfileFactory {
    private static ViewProfileFactory viewProfileFactory = null;
    IViewProfileModel viewProfileModel;
    IViewProfileConnection viewProfileConnection;
    IUpdateProfileConnection updateProfileConnection;

    public ViewProfileFactory() {
        viewProfileConnection = new ViewProfileConnection();
        updateProfileConnection = new UpdateProfileConnection();
        viewProfileModel = new ViewProfileModel();
    }

    public static ViewProfileFactory initialize() {
        if (viewProfileFactory == null) {
            viewProfileFactory = new ViewProfileFactory();
        }
        return viewProfileFactory;
    }

    public IViewProfileModel getViewProfileModel() {
        return viewProfileModel;
    }

    public IViewProfileConnection getViewProfileConnection() {
        return viewProfileConnection;
    }

    public IUpdateProfileConnection getUpdateProfileConnection() {
        return updateProfileConnection;
    }
}
