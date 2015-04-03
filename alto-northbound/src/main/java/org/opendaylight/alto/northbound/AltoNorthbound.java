/*
 * Copyright (c) 2015 Yale University and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.alto.northbound;

import org.opendaylight.alto.commons.types.RFC7285MediaType;
import org.opendaylight.alto.services.api.IRDService;

//import org.opendaylight.yang.gen.v1.urn.opendaylight.alto.service.types.rev141101.NetworkMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.alto.service.types.rev141101.IRD;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class AltoNorthbound {

    private static final Logger mLogger = LoggerFactory.getLogger(AltoNorthbound.class);

    @GET
    @Produces({RFC7285MediaType.ALTO_DIRECTORY, RFC7285MediaType.ALTO_ERROR})
    public Response retrieveIRD() {
        IRDService fas = new FakeAltoService();
        try {
            IRD ird = fas.getIRD();
            return Response.ok(ird, RFC7285MediaType.ALTO_DIRECTORY).build();
        } catch (Exception e) {
        }
        return Response.ok("", RFC7285MediaType.ALTO_ERROR).build();
    }

    @Path("/networkmap/{networkmap_id}")
    @GET
    @Produces({RFC7285MediaType.ALTO_NETWORKMAP, RFC7285MediaType.ALTO_ERROR})
    public Response retrieveNetworkMap(@PathParam(value = "networkmap_id") String nmap_id) {
        /* TODO */
        return Response.ok("", RFC7285MediaType.ALTO_ERROR).build();
    }
}