package com.kyrostechnologies.crm.application.googlecontacts.interfaceclass;

import com.kyrostechnologies.crm.model.GoogleContactsModel;
import com.kyrostechnologies.crm.response.GoogleContactsResponse;

public interface GoogleContactsInterface {
    GoogleContactsResponse getGoogleContactByUserProfileId(int UserProfileId);
    GoogleContactsResponse getGoogleContactByContactId(int ContactId);
    GoogleContactsResponse insertGoogleContacts(GoogleContactsModel model);
    GoogleContactsResponse updateGoogleContacts(GoogleContactsModel model);
    GoogleContactsResponse deleteGoogleContacts(GoogleContactsModel model);
}
