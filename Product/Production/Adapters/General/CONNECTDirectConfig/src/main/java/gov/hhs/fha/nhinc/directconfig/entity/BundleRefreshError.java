/*
Copyright (c) 2010, NHIN Direct Project
All rights reserved.

Authors:
   Greg Meyer      gm2552@cerner.com

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer
in the documentation and/or other materials provided with the distribution.  Neither the name of the The NHIN Direct Project (nhindirect.org).
nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
THE POSSIBILITY OF SUCH DAMAGE.
*/

package gov.hhs.fha.nhinc.directconfig.entity;

/**
 * Enumeration for bundle update and refresh statuses
 * @author Greg Meyer
 * @since 1.2
 */
public enum BundleRefreshError
{
    /**
     * Successful update.
     */
    SUCCESS,

    /**
     * The bundle was not found at the URL specified.
     */
    NOT_FOUND,

    /**
     * The download from the URL timed out.
     */
    DOWNLOAD_TIMEOUT,

    /**
     * The bundle is either corrupt or in an unrecognized format.
     */
    INVALID_BUNDLE_FORMAT,

    /**
     * The signing certificate specified is not a valid certificate.
     */
    INVALID_SIGNING_CERT,

    /**
     * The signature on the signed bundle did not validate successfully against the signing certificate.
     */
    UNMATCHED_SIGNATURE
}
