package willydekeyser.dto;

import lombok.Builder;

@Builder
public record AuthorityDto(
		Integer id,
		String authority) {}
