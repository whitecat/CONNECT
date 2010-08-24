package gov.hhs.fha.nhinc.patientdiscovery.passthru.deferred.response.proxy;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetSystemType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hl7.v3.MCCIIN000002UV01;
import org.hl7.v3.ProxyPRPAIN201306UVProxyRequestType;

/**
 *
 * @author Neil Webb
 */
public class PassthruPatientDiscoveryDeferredRespProxyJavaImpl implements PassthruPatientDiscoveryDeferredRespProxy
{
    private Log log = null;

    public PassthruPatientDiscoveryDeferredRespProxyJavaImpl()
    {
        log = createLogger();
    }

    protected Log createLogger()
    {
        return LogFactory.getLog(getClass());
    }


    public MCCIIN000002UV01 proxyProcessPatientDiscoveryAsyncResp(ProxyPRPAIN201306UVProxyRequestType proxyProcessPatientDiscoveryAsyncRespRequest, AssertionType assertion, NhinTargetSystemType targetSystem)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}