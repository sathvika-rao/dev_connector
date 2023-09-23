package com.dnb.devConnector.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class SocialNetworkLinks {
	private String twitterURL;
	private String facebookURL;
	private String youtubeURL;
	private String linkedinURL;
	private String instagramURL;
}
