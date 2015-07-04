package com.aplos.${artifactId}.enums;

import com.aplos.common.beans.communication.EmailTemplate;
import com.aplos.common.enums.EmailTemplateEnum;

public enum ${projectName}EmailTemplateEnum implements EmailTemplateEnum {
	;

	private Class<? extends EmailTemplate> emailTemplateClass;
	boolean isActive = true;

	private ${projectName}EmailTemplateEnum( Class<? extends EmailTemplate> emailTemplateClass ) {
		this.emailTemplateClass = emailTemplateClass;
	}

	@Override
	public Class<? extends EmailTemplate> getEmailTemplateClass() {
		return emailTemplateClass;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
