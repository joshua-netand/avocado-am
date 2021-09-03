package com.netand.avocado.commons.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netand.avocado.commons.model.converter.json.IntegerCodeSerializer;
import com.netand.avocado.commons.model.enums.EventTypes;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@RequiredArgsConstructor
@ToString
public abstract class EventLog< T extends EventTypes > {

	private Long eventId;

	private ZonedDateTime eventTime;

	@JsonSerialize( using = IntegerCodeSerializer.class )
	private T eventType;

	private ActorTag actorTag;

	public EventLog( Long eventId, ZonedDateTime eventTime, T eventType, ActorTag actorTag ) {

		this.eventId = eventId;
		this.eventTime = eventTime;
		this.eventType = eventType;
		this.actorTag = actorTag;
	}
}
