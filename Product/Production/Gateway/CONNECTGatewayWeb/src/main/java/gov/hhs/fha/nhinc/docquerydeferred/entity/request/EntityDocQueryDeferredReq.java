package gov.hhs.fha.nhinc.docquerydeferred.entity.request;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import gov.hhs.fha.nhinc.common.nhinccommonentity.RespondingGatewayCrossGatewayQueryRequestType;
import gov.hhs.healthit.nhin.DocQueryAcknowledgementType;

/**
 * This is an Entity Unsecure service for Document Query Deferred Request message
 * @author Mark Goldman
 */
@WebService(serviceName = "EntityDocQueryDeferredRequest", portName = "EntityDocQueryDeferredRequestPortSoap", endpointInterface = "gov.hhs.fha.nhinc.entitydocquerydeferredrequest.EntityDocQueryDeferredRequestPortType", targetNamespace = "urn:gov:hhs:fha:nhinc:entitydocquerydeferredrequest", wsdlLocation = "WEB-INF/wsdl/EntityDocQueryDeferredReq/EntityDocQueryDeferredRequest.wsdl")
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class EntityDocQueryDeferredReq {

  /**
   * The Entity Secured Method implementation for RespondingGatewayCrossGatewayQuery makes call to actual implementation
   * @param respondingGatewayCrossGatewayQueryRequest
   * @return DocQueryAcknowledgementsType
   */
  public DocQueryAcknowledgementType respondingGatewayCrossGatewayQuery(RespondingGatewayCrossGatewayQueryRequestType respondingGatewayCrossGatewayQueryRequest) {
    return null;
  }
}