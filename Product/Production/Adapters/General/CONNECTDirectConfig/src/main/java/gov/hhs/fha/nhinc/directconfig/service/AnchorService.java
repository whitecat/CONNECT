/*
 * Copyright (c) 2009-2014, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*
 Copyright (c) 2010, NHIN Direct Project
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer
 in the documentation and/or other materials provided with the distribution.
 3. Neither the name of the The NHIN Direct Project (nhindirect.org) nor the names of its contributors may be used to endorse or promote
 products derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS
 BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 THE POSSIBILITY OF SUCH DAMAGE.
 */

package gov.hhs.fha.nhinc.directconfig.service;

import gov.hhs.fha.nhinc.directconfig.entity.Anchor;
import gov.hhs.fha.nhinc.directconfig.entity.helpers.EntityStatus;
import gov.hhs.fha.nhinc.directconfig.service.helpers.CertificateGetOptions;
import gov.hhs.fha.nhinc.directconfig.service.jaxws.AddAnchors;
import gov.hhs.fha.nhinc.directconfig.service.jaxws.AddAnchorsResponse;
import gov.hhs.fha.nhinc.directconfig.service.jaxws.GetAnchorsForOwner;
import gov.hhs.fha.nhinc.directconfig.service.jaxws.GetAnchorsForOwnerResponse;
import gov.hhs.fha.nhinc.directconfig.service.jaxws.RemoveAnchors;
import gov.hhs.fha.nhinc.directconfig.service.jaxws.RemoveAnchorsResponse;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Service class for methods related to an Anchor object.
 */
@WebService
public interface AnchorService {

    /**
     * Add a collection of Anchors.
     *
     * @param anchors A collection of Anchors.
     * @throws ConfigurationServiceException
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "addAnchorResponse", targetNamespace = "http://nhind.org/config/common", partName = "parameters")
    @WebMethod(operationName = "addAnchor", action = "urn:AddAnchor")
    AddAnchorsResponse addAnchors(
            @WebParam(partName = "parameters", name = "addAnchor", targetNamespace = "http://nhind.org/config/common") AddAnchors addAnchors)
                    throws ConfigurationServiceException;

    /**
     * Get an Anchor.
     *
     * @param owner The Anchor owner.
     * @param thumbprint The Anchor thumbprint.
     * @param options The Anchor options.
     * @return an Anchor.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "getAnchor", action = "urn:GetAnchor")
    public Anchor getAnchor(@WebParam(name = "owner") String owner, @WebParam(name = "thumbprint") String thumbprint,
            @WebParam(name = "options") CertificateGetOptions options) throws ConfigurationServiceException;

    /**
     * Get a collection of Anchors.
     *
     * @param anchorIds A collection of Anchor IDs.
     * @param options The Anchor options.
     * @return a collection of Anchors.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "getAnchors", action = "urn:GetAnchors")
    public Collection<Anchor> getAnchors(@WebParam(name = "anchorId") Collection<Long> anchorIds,
            @WebParam(name = "options") CertificateGetOptions options) throws ConfigurationServiceException;

    /**
     * Get a collection of Anchors for an owner.
     *
     * @param owner The Anchor owner.
     * @param options The Anchor options.
     * @return a collection of Anchors.
     * @throws ConfigurationServiceException
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "getAnchorsForOwnerResponse", targetNamespace = "http://nhind.org/config/common", partName = "parameters")
    @WebMethod(operationName = "getAnchorsForOwner", action = "urn:GetAnchorsForOwner")
    GetAnchorsForOwnerResponse getAnchorsForOwner(
            @WebParam(partName = "parameters", name = "getAnchorsForOwner", targetNamespace = "http://nhind.org/config/common") GetAnchorsForOwner getAnchors)
                    throws ConfigurationServiceException;

    /**
     * Get a collection of incoming Anchors.
     *
     * @param owner The Anchor owner.
     * @param options The Anchor options.
     * @return a collection of Anchors.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "getIncomingAnchors", action = "urn:GetIncomingAnchors")
    public Collection<Anchor> getIncomingAnchors(@WebParam(name = "owner") String owner,
            @WebParam(name = "options") CertificateGetOptions options) throws ConfigurationServiceException;

    /**
     * Get a collection of outgoing Anchors.
     *
     * @param owner The Anchor owner.
     * @param options The Anchor options.
     * @return a collection of Anchors.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "getOutgoingAnchors", action = "urn:GetOutgoingAnchors")
    public Collection<Anchor> getOutgoingAnchors(@WebParam(name = "owner") String owner,
            @WebParam(name = "options") CertificateGetOptions options) throws ConfigurationServiceException;

    /**
     * Set an Anchor status for a given owner.
     *
     * @param owner The anchor owner.
     * @param status The anchor status.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "setAnchorStatusForOwner", action = "urn:SetAnchorStatusForOwner")
    public void setAnchorStatusForOwner(@WebParam(name = "owner") String owner,
            @WebParam(name = "status") EntityStatus status) throws ConfigurationServiceException;

    /**
     * Get a collection of Anchors.
     *
     * @param lastAnchorID The last Anchor ID.
     * @param maxResults The maximum number of results.
     * @param options The Anchor options.
     * @return a collection of Anchors.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "listAnchors", action = "urn:ListAnchors")
    public Collection<Anchor> listAnchors(@WebParam(name = "lastAnchorId") Long lastAnchorID,
            @WebParam(name = "maxResults") int maxResults, @WebParam(name = "options") CertificateGetOptions options)
            throws ConfigurationServiceException;

    /**
     * Remove an Anchor.
     *
     * @param anchorIds A collection of Anchor IDs.
     * @throws ConfigurationServiceException
     */
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "removeAnchorsResponse", targetNamespace = "http://nhind.org/config/common", partName = "parameters")
    @WebMethod(operationName = "removeAnchors", action = "urn:RemoveAnchors")
    RemoveAnchorsResponse removeAnchors(
            @WebParam(partName = "parameters", name = "removeAnchors", targetNamespace = "http://nhind.org/config/common") RemoveAnchors removeAnchors)
                    throws ConfigurationServiceException;

    /**
     * Remove the Anchors for an owner.
     *
     * @param owner The Anchor owner.
     * @throws ConfigurationServiceException
     */
    @WebMethod(operationName = "removeAnchorsForOwner", action = "urn:RemoveAnchorsForOwner")
    public void removeAnchorsForOwner(@WebParam(name = "owner") String owner) throws ConfigurationServiceException;

}
