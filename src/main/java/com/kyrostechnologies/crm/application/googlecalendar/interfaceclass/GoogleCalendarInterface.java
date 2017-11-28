package com.kyrostechnologies.crm.application.googlecalendar.interfaceclass;

import com.kyrostechnologies.crm.model.GoogleCalanderModel;
import com.kyrostechnologies.crm.response.GoogleCalanderResponse;

public interface GoogleCalendarInterface{
    GoogleCalanderResponse getGoogleCalendarByUserProfileId(int UserProfileId);
    GoogleCalanderResponse getGoogleCalendarByConnectionId(int ConnectionId);
    GoogleCalanderResponse insertGoogleCalendar(GoogleCalanderModel model);
    GoogleCalanderResponse updateGoogleCalendar(GoogleCalanderModel model);
    GoogleCalanderResponse deleteGoogleCalendar(GoogleCalanderModel model);

}
