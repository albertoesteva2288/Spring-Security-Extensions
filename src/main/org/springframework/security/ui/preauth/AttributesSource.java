/*
 * Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.security.ui.preauth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Source of the attributes associated with pre-authenticated authentication request. The attributes
 * can be supplied in the cookies, request header, request parameter, or property (configuration
 * file).
 *
 * @author Valery Tydykov
 *
 */
public interface AttributesSource {
    /**
     * Obtain attributes supplied in the request or property.
     *
     * @param request with optional attributes.
     * @return Map<String, String> of attributes: name/value.
     */
    Map<String, String> obtainAttributes(HttpServletRequest request);
}
