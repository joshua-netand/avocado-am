package com.netand.avocado.commons.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PartialRequestOption {
	
	private int offset;
	private int limit;

	@Builder
	public PartialRequestOption( int offset, int limit ) {

		this.offset = offset;
		this.limit = limit;
	}
}