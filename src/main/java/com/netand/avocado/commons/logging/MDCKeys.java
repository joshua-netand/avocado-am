package com.netand.avocado.commons.logging;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public interface MDCKeys {

	//@formatter:off
    String Request_Id                       = "request.id";
    String Request_Time                     = "request.time";
    String Request_RemoteAddress            = "request.remote-address";
    String Request_RemotePort               = "request.remote-port";
    String Request_ClientId                 = "request.client-id";
    String Request_ClientName               = "request.client-name";
    String Request_UserId                   = "request.user-id";
    String Request_UserUid                  = "request.user-uid";
    String Request_CompanyId                = "request.company-id";

    String Response_Status                  = "response.remote-status";

    String Service_Name                     = "service.name";
    String Service_Version                  = "service.version";
    String Service_HostName                 = "service.host-name";
    String Service_Environment_ProfileName  = "service.environment.profile-name";

    String Application_InstanceId           = "application.instance-id";
    //@formatter:on
}