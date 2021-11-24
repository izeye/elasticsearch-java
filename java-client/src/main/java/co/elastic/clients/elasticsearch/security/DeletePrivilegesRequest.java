/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.security;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.Refresh;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nullable;

// typedef: security.delete_privileges.Request

public class DeletePrivilegesRequest extends RequestBase {
	private final String application;

	private final String name;

	@Nullable
	private final Refresh refresh;

	// ---------------------------------------------------------------------------------------------

	private DeletePrivilegesRequest(Builder builder) {

		this.application = ModelTypeHelper.requireNonNull(builder.application, this, "application");
		this.name = ModelTypeHelper.requireNonNull(builder.name, this, "name");
		this.refresh = builder.refresh;

	}

	public static DeletePrivilegesRequest of(Consumer<Builder> fn) {
		Builder builder = new Builder();
		fn.accept(builder);
		return builder.build();
	}

	/**
	 * Required - Application name
	 * <p>
	 * API name: {@code application}
	 */
	public final String application() {
		return this.application;
	}

	/**
	 * Required - Privilege name
	 * <p>
	 * API name: {@code name}
	 */
	public final String name() {
		return this.name;
	}

	/**
	 * If <code>true</code> (the default) then refresh the affected shards to make
	 * this operation visible to search, if <code>wait_for</code> then wait for a
	 * refresh to make this operation visible to search, if <code>false</code> then
	 * do nothing with refreshes.
	 * <p>
	 * API name: {@code refresh}
	 */
	@Nullable
	public final Refresh refresh() {
		return this.refresh;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DeletePrivilegesRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeletePrivilegesRequest> {
		private String application;

		private String name;

		@Nullable
		private Refresh refresh;

		/**
		 * Required - Application name
		 * <p>
		 * API name: {@code application}
		 */
		public final Builder application(String value) {
			this.application = value;
			return this;
		}

		/**
		 * Required - Privilege name
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * If <code>true</code> (the default) then refresh the affected shards to make
		 * this operation visible to search, if <code>wait_for</code> then wait for a
		 * refresh to make this operation visible to search, if <code>false</code> then
		 * do nothing with refreshes.
		 * <p>
		 * API name: {@code refresh}
		 */
		public final Builder refresh(@Nullable Refresh value) {
			this.refresh = value;
			return this;
		}

		/**
		 * Builds a {@link DeletePrivilegesRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DeletePrivilegesRequest build() {
			_checkSingleUse();

			return new DeletePrivilegesRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code security.delete_privileges}".
	 */
	public static final Endpoint<DeletePrivilegesRequest, DeletePrivilegesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/security.delete_privileges",

			// Request method
			request -> {
				return "DELETE";

			},

			// Request path
			request -> {
				final int _application = 1 << 0;
				final int _name = 1 << 1;

				int propsSet = 0;

				propsSet |= _application;
				propsSet |= _name;

				if (propsSet == (_application | _name)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_security");
					buf.append("/privilege");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.application, buf);
					buf.append("/");
					SimpleEndpoint.pathEncode(request.name, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.refresh != null) {
					params.put("refresh", request.refresh.jsonValue());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, DeletePrivilegesResponse._DESERIALIZER);
}
