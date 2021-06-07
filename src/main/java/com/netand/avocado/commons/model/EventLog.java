package com.netand.avocado.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
@ToString
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class EventLog< T extends EventTypes > {

	private long eventId;

	private ZonedDateTime eventTime;

	private T eventType;

	private ActorTag actorTag;

	public EventLog( long eventId, ZonedDateTime eventTime, T eventType, ActorTag actorTag ) {

		this.eventId = eventId;
		this.eventTime = eventTime;
		this.eventType = eventType;
		this.actorTag = actorTag;
	}
}


