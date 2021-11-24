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

package co.elastic.clients.elasticsearch.indices.update_aliases;

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
import java.lang.Object;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nullable;

// typedef: indices.update_aliases.Action
// union type: Container[]
@JsonpDeserializable
public class Action implements TaggedUnion<Action.Kind, Object>, JsonpSerializable {

	/**
	 * {@link Action} variant kinds.
	 */

	public enum Kind implements JsonEnum {
		Add("add"),

		Remove("remove"),

		RemoveIndex("remove_index"),

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
	private final Object _value;

	@Override
	public final Kind _kind() {
		return _kind;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	public Action(ActionVariant value) {

		this._kind = ModelTypeHelper.requireNonNull(value._actionKind(), this, "<variant kind>");
		this._value = ModelTypeHelper.requireNonNull(value, this, "<variant value>");

	}

	private Action(Builder builder) {

		this._kind = ModelTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static Action of(Consumer<Builder> fn) {
		Builder builder = new Builder();
		fn.accept(builder);
		return builder.build();
	}

	/**
	 * Is this variant instance of kind {@code add}?
	 */
	public boolean isAdd() {
		return _kind == Kind.Add;
	}

	/**
	 * Get the {@code add} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code add} kind.
	 */
	public AddAction add() {
		return TaggedUnionUtils.get(this, Kind.Add);
	}

	/**
	 * Is this variant instance of kind {@code remove}?
	 */
	public boolean isRemove() {
		return _kind == Kind.Remove;
	}

	/**
	 * Get the {@code remove} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code remove} kind.
	 */
	public RemoveAction remove() {
		return TaggedUnionUtils.get(this, Kind.Remove);
	}

	/**
	 * Is this variant instance of kind {@code remove_index}?
	 */
	public boolean isRemoveIndex() {
		return _kind == Kind.RemoveIndex;
	}

	/**
	 * Get the {@code remove_index} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code remove_index} kind.
	 */
	public RemoveIndexAction removeIndex() {
		return TaggedUnionUtils.get(this, Kind.RemoveIndex);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeStartObject();

		generator.writeKey(_kind.jsonValue());
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		}

		generator.writeEnd();

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Action> {
		private Kind _kind;
		private Object _value;

		public ObjectBuilder<Action> add(AddAction v) {
			this._kind = Kind.Add;
			this._value = v;
			return this;
		}

		public ObjectBuilder<Action> add(Consumer<AddAction.Builder> fn) {
			AddAction.Builder builder = new AddAction.Builder();
			fn.accept(builder);
			return this.add(builder.build());
		}

		public ObjectBuilder<Action> remove(RemoveAction v) {
			this._kind = Kind.Remove;
			this._value = v;
			return this;
		}

		public ObjectBuilder<Action> remove(Consumer<RemoveAction.Builder> fn) {
			RemoveAction.Builder builder = new RemoveAction.Builder();
			fn.accept(builder);
			return this.remove(builder.build());
		}

		public ObjectBuilder<Action> removeIndex(RemoveIndexAction v) {
			this._kind = Kind.RemoveIndex;
			this._value = v;
			return this;
		}

		public ObjectBuilder<Action> removeIndex(Consumer<RemoveIndexAction.Builder> fn) {
			RemoveIndexAction.Builder builder = new RemoveIndexAction.Builder();
			fn.accept(builder);
			return this.removeIndex(builder.build());
		}

		public Action build() {
			_checkSingleUse();
			return new Action(this);
		}

	}

	protected static void setupActionDeserializer(ObjectDeserializer<Builder> op) {

		op.add(Builder::add, AddAction._DESERIALIZER, "add");
		op.add(Builder::remove, RemoveAction._DESERIALIZER, "remove");
		op.add(Builder::removeIndex, RemoveIndexAction._DESERIALIZER, "remove_index");

	}

	public static final JsonpDeserializer<Action> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Action::setupActionDeserializer, Builder::build);
}
