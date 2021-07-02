package com.netand.avocado.commons.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netand.avocado.commons.model.converter.json.EventTypeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.Map;

@Getter
@NoArgsConstructor
@ToString
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class EventLog< T extends EventTypes > {

	private long eventId;

	private ZonedDateTime eventTime;

	@JsonSerialize( using = EventTypeSerializer.class )
	private T eventType;

	private ActorTag actorTag;

	public EventLog( long eventId, ZonedDateTime eventTime, T eventType, ActorTag actorTag ) {

		this.eventId = eventId;
		this.eventTime = eventTime;
		this.eventType = eventType;
		this.actorTag = actorTag;
	}
}
