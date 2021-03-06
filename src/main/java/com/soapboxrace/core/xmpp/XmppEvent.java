/*
 * This file is part of the Soapbox Race World core source code.
 * If you use any of this code for third-party purposes, please provide attribution.
 * Copyright (c) 2020.
 */

package com.soapboxrace.core.xmpp;

import com.soapboxrace.jaxb.xmpp.*;

public class XmppEvent {

    private long personaId;

    private OpenFireSoapBoxCli openFireSoapBoxCli;

    public XmppEvent(long personaId, OpenFireSoapBoxCli openFireSoapBoxCli) {
        this.personaId = personaId;
        this.openFireSoapBoxCli = openFireSoapBoxCli;
    }

    public void sendRaceEnd(XMPP_ResponseTypeRouteEntrantResult routeEntrantResultResponse) {
        openFireSoapBoxCli.send(routeEntrantResultResponse, personaId);
    }

    public void sendTeamEscapeEnd(XMPP_ResponseTypeTeamEscapeEntrantResult teamEscapeEntrantResultResponse) {
        openFireSoapBoxCli.send(teamEscapeEntrantResultResponse, personaId);
    }

    public void sendDragEnd(XMPP_ResponseTypeDragEntrantResult dragEntrantResultResponse) {
        openFireSoapBoxCli.send(dragEntrantResultResponse, personaId);
    }

    public void sendEventTimingOut(Long eventSessionId) {
        XMPP_EventTimingOutType eventTimingOut = new XMPP_EventTimingOutType();
        eventTimingOut.setEventSessionId(eventSessionId);
        XMPP_ResponseTypeEventTimingOut eventTimingOutResponse = new XMPP_ResponseTypeEventTimingOut();
        eventTimingOutResponse.setEventTimingOut(eventTimingOut);
        openFireSoapBoxCli.send(eventTimingOutResponse, personaId);
    }

}