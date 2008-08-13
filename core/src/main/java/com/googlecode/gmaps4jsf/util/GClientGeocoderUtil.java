/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.googlecode.gmaps4jsf.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.googlecode.gmaps4jsf.component.map.Map;

/**
 * @author Hazem Saleh
 * @date Aug 12, 2008
 * The GClientGeocoderUtil acts a wrapper for GMaps (GClientGeocoder) service.
 */
public class GClientGeocoderUtil {
	
	public static void initMapLocation(FacesContext facesContext, Map mapComponent,
			ResponseWriter writer) throws IOException {

		writer.write("var geocoder_" + mapComponent.getId()
				+ " = new GClientGeocoder();");

		// send XHR request to get the address location and write to the response.
		writer.write("geocoder_" + mapComponent.getId() + ".getLatLng(\""
				+ mapComponent.getAddress() + "\"," + "function(location) {\n"
				+ "if (!location) {\n" + "alert(\""
				+ mapComponent.getLocationNotFoundErrorMessage() + "\");\n"
				+ "} else {\n" 
				+ "map.setCenter(location, "
				+ mapComponent.getZoom() + ");\n" + "}" + "}\n" + ");\n");
	}
}