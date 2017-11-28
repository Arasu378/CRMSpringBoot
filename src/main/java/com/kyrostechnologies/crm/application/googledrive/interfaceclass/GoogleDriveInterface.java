package com.kyrostechnologies.crm.application.googledrive.interfaceclass;

import com.kyrostechnologies.crm.model.GoogleDriveModel;
import com.kyrostechnologies.crm.response.GoogleDriveResponse;

public interface GoogleDriveInterface {
    GoogleDriveResponse getGoogleDriveByDriveId(int GoogleDriveId);
    GoogleDriveResponse insertGoogleDrive(GoogleDriveModel model);
    GoogleDriveResponse updateGoogleDrive(GoogleDriveModel model);
    GoogleDriveResponse deleteGoogleDrive(GoogleDriveModel model);
}
