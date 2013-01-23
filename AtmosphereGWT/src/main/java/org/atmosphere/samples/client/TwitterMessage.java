/*
 * Copyright 2002-2010 the original author or authors
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package org.atmosphere.samples.client;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents some common Twitter related fields.
 * 
 * @author Gunnar Hillert
 * @since 1.0
 * 
 */

public class TwitterMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1732379720069972240L;
	private Long id;
	private Date createdAt;
	private String text;
	private String fromUser;
	private String profileImageUrl;

	/** Default constructor. */
	public TwitterMessage() {
	}

	/** Constructor to initialize all fields available. */
	public TwitterMessage(Long id, Date createdAt, String text, String fromUser, String profileImageUrl) {
		this.id = id;
		this.createdAt = createdAt;
		this.text = text;
		this.fromUser = fromUser;
		this.profileImageUrl = profileImageUrl;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
