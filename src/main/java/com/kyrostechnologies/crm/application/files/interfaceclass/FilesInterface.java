package com.kyrostechnologies.crm.application.files.interfaceclass;

import com.kyrostechnologies.crm.model.FilesModel;
import com.kyrostechnologies.crm.response.FilesResponse;
;

public interface FilesInterface {
    FilesResponse getFilesByUserProfileId(int UserProfileId);
    FilesResponse getFilesByFileId(int FileId);
    FilesResponse insertFiles(FilesModel model);
    FilesResponse updateFiles(FilesModel model);
    FilesResponse deleteFiles(FilesModel model);
}
