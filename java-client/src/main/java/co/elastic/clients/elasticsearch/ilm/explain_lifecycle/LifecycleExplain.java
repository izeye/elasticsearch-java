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

package co.elastic.clients.elasticsearch.ilm.explain_lifecycle;

import co.elastic.clients.json.JsonEnum;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import co.elastic.clients.util.TaggedUnion;
import co.elastic.clients.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nullable;

// typedef: ilm.explain_lifecycle.LifecycleExplain
// union type: InternalTag[tag=managed]
@JsonpDeserializable
public class LifecycleExplain
		implements
			TaggedUnion<LifecycleExplain.Kind, LifecycleExplainVariant>,
			JsonpSerializable {

	/**
	 * {@link LifecycleExplain} variant kinds.
	 */

	public enum Kind implements JsonEnum {
		True("true"),

		False("false"),

		;

		private final String jsonValue;

		Kind(String jsonValue) {
			this.jsonValue = jsonValue;
		}

		public String jsonValue() {
			return this.jsonValue;
		}

	}

	private final Kind _kind;
	private final LifecycleExplainVariant _value;

	@Override
	public final Kind _kind() {
		return _kind;
	}

	@Override
	public final LifecycleExplainVariant _get() {
		return _value;
	}

	public LifecycleExplain(LifecycleExplainVariant value) {

		this._kind = ModelTypeHelper.requireNonNull(value._lifecycleExplainKind(), this, "<variant kind>");
		this._value = ModelTypeHelper.requireNonNull(value, this, "<variant value>");

	}

	private LifecycleExplain(Builder builder) {

		this._kind = ModelTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static LifecycleExplain of(Consumer<Builder> fn) {
		Builder builder = new Builder();
		fn.accept(builder);
		return builder.build();
	}

	/**
	 * Is this variant instance of kind {@code true}?
	 */
	public boolean isTrue() {
		return _kind == Kind.True;
	}

	/**
	 * Get the {@code true} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code true} kind.
	 */
	public LifecycleExplainManaged true_() {
		return TaggedUnionUtils.get(this, Kind.True);
	}

	/**
	 * Is this variant instance of kind {@code false}?
	 */
	public boolean isFalse() {
		return _kind == Kind.False;
	}

	/**
	 * Get the {@code false} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code false} kind.
	 */
	public LifecycleExplainUnmanaged false_() {
		return TaggedUnionUtils.get(this, Kind.False);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {

		mapper.serialize(_value, generator);

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<LifecycleExplain> {
		private Kind _kind;
		private LifecycleExplainVariant _value;

		public ObjectBuilder<LifecycleExplain> true_(LifecycleExplainManaged v) {
			this._kind = Kind.True;
			this._value = v;
			return this;
		}

		public ObjectBuilder<LifecycleExplain> true_(Consumer<LifecycleExplainManaged.Builder> fn) {
			LifecycleExplainManaged.Builder builder = new LifecycleExplainManaged.Builder();
			fn.accept(builder);
			return this.true_(builder.build());
		}

		public ObjectBuilder<LifecycleExplain> false_(LifecycleExplainUnmanaged v) {
			this._kind = Kind.False;
			this._value = v;
			return this;
		}

		public ObjectBuilder<LifecycleExplain> false_(Consumer<LifecycleExplainUnmanaged.Builder> fn) {
			LifecycleExplainUnmanaged.Builder builder = new LifecycleExplainUnmanaged.Builder();
			fn.accept(builder);
			return this.false_(builder.build());
		}

		public LifecycleExplain build() {
			_checkSingleUse();
			return new LifecycleExplain(this);
		}

	}

	protected static void setupLifecycleExplainDeserializer(ObjectDeserializer<Builder> op) {

		op.add(Builder::true_, LifecycleExplainManaged._DESERIALIZER, "true");
		op.add(Builder::false_, LifecycleExplainUnmanaged._DESERIALIZER, "false");

		op.setTypeProperty("managed", null);

	}

	public static final JsonpDeserializer<LifecycleExplain> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			LifecycleExplain::setupLifecycleExplainDeserializer, Builder::build);
}
