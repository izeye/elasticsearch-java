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

package co.elastic.clients.elasticsearch.cluster;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.Time;
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
import java.lang.Boolean;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: cluster.stats.Request

public class ClusterStatsRequest extends RequestBase {
	@Nullable
	private final Boolean flatSettings;

	private final List<String> nodeId;

	@Nullable
	private final Time timeout;

	// ---------------------------------------------------------------------------------------------

	private ClusterStatsRequest(Builder builder) {

		this.flatSettings = builder.flatSettings;
		this.nodeId = ModelTypeHelper.unmodifiable(builder.nodeId);
		this.timeout = builder.timeout;

	}

	public static ClusterStatsRequest of(Consumer<Builder> fn) {
		Builder builder = new Builder();
		fn.accept(builder);
		return builder.build();
	}

	/**
	 * Return settings in flat format (default: false)
	 * <p>
	 * API name: {@code flat_settings}
	 */
	@Nullable
	public final Boolean flatSettings() {
		return this.flatSettings;
	}

	/**
	 * Comma-separated list of node filters used to limit returned information.
	 * Defaults to all nodes in the cluster.
	 * <p>
	 * API name: {@code node_id}
	 */
	public final List<String> nodeId() {
		return this.nodeId;
	}

	/**
	 * Period to wait for each node to respond. If a node does not respond before
	 * its timeout expires, the response does not include its stats. However, timed
	 * out nodes are included in the response’s _nodes.failed property. Defaults to
	 * no timeout.
	 * <p>
	 * API name: {@code timeout}
	 */
	@Nullable
	public final Time timeout() {
		return this.timeout;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ClusterStatsRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterStatsRequest> {
		@Nullable
		private Boolean flatSettings;

		@Nullable
		private List<String> nodeId;

		@Nullable
		private Time timeout;

		/**
		 * Return settings in flat format (default: false)
		 * <p>
		 * API name: {@code flat_settings}
		 */
		public final Builder flatSettings(@Nullable Boolean value) {
			this.flatSettings = value;
			return this;
		}

		/**
		 * Comma-separated list of node filters used to limit returned information.
		 * Defaults to all nodes in the cluster.
		 * <p>
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(@Nullable List<String> value) {
			this.nodeId = value;
			return this;
		}

		/**
		 * Comma-separated list of node filters used to limit returned information.
		 * Defaults to all nodes in the cluster.
		 * <p>
		 * API name: {@code node_id}
		 */
		public final Builder nodeId(String... value) {
			this.nodeId = Arrays.asList(value);
			return this;
		}

		/**
		 * Period to wait for each node to respond. If a node does not respond before
		 * its timeout expires, the response does not include its stats. However, timed
		 * out nodes are included in the response’s _nodes.failed property. Defaults to
		 * no timeout.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(@Nullable Time value) {
			this.timeout = value;
			return this;
		}

		/**
		 * Period to wait for each node to respond. If a node does not respond before
		 * its timeout expires, the response does not include its stats. However, timed
		 * out nodes are included in the response’s _nodes.failed property. Defaults to
		 * no timeout.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(Consumer<Time.Builder> fn) {
			Time.Builder builder = new Time.Builder();
			fn.accept(builder);
			return this.timeout(builder.build());
		}

		/**
		 * Builds a {@link ClusterStatsRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ClusterStatsRequest build() {
			_checkSingleUse();

			return new ClusterStatsRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cluster.stats}".
	 */
	public static final Endpoint<ClusterStatsRequest, ClusterStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/cluster.stats",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _nodeId = 1 << 0;

				int propsSet = 0;

				if (ModelTypeHelper.isDefined(request.nodeId()))
					propsSet |= _nodeId;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_cluster");
					buf.append("/stats");
					return buf.toString();
				}
				if (propsSet == (_nodeId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_cluster");
					buf.append("/stats");
					buf.append("/nodes");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.nodeId.stream().map(v -> v).collect(Collectors.joining(",")),
							buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.flatSettings != null) {
					params.put("flat_settings", String.valueOf(request.flatSettings));
				}
				if (request.timeout != null) {
					params.put("timeout", request.timeout._toJsonString());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, ClusterStatsResponse._DESERIALIZER);
}
