package com.aplos.${artifactId}.module;

import com.aplos.${artifactId}.enums.${projectName}EmailTemplateEnum;
#if( ${projectType} == "cms" || ${projectType} == "ecommerce" )
import com.aplos.cms.enums.UnconfigurableAtomEnum;
import com.aplos.cms.module.CmsConfiguration;
#end
import com.aplos.common.enums.SslProtocolEnum;
import com.aplos.common.listeners.AplosContextListener;
import com.aplos.common.module.CommonConfiguration;
import com.aplos.common.module.ModuleConfiguration;
import com.aplos.common.annotations.persistence.Entity;

@Entity
public class ${projectName}Configuration extends ModuleConfiguration {

#if( ${projectType} == "cms" || ${projectType} == "ecommerce" )
	public enum ${projectName}UnconfigurableAtomEnum implements UnconfigurableAtomEnum {
		;

		String cmsAtomIdStr;
		String cmsAtomName;
		SslProtocolEnum sslProtocolEnum;
		boolean isActive = true;
		

		private ${projectName}UnconfigurableAtomEnum( String cmsAtomIdStr, String cmsAtomName, SslProtocolEnum sslProtocolEnum ) {
			this.cmsAtomIdStr = cmsAtomIdStr;
			this.cmsAtomName = cmsAtomName;
			this.sslProtocolEnum = sslProtocolEnum;
		}

		@Override
		public String getCmsAtomIdStr() {
			return cmsAtomIdStr;
		}

		@Override
		public String getCmsAtomName() {
			return cmsAtomName;
		}
		
		@Override
		public SslProtocolEnum getSslProtocolEnum() {
			return sslProtocolEnum;
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
#end

	@Override
	public int getMaximumModuleVersionMajor() {
		return 1;
	}

	@Override
	public int getMaximumModuleVersionMinor() {
		return 0;
	}

	@Override
	public int getMaximumModuleVersionPatch() {
		return 0;
	}

	@Override
	public boolean recursiveModuleConfigurationInit(
			AplosContextListener aplosContextListener, int loopCount) {
		super.recursiveModuleConfigurationInit(aplosContextListener, loopCount);

		if( loopCount == 0 ) {
			CommonConfiguration commonConfiguration = CommonConfiguration.getCommonConfiguration();
			commonConfiguration.registerEmailTemplateEnums( CommonConfiguration.getActiveEmailTemplateEnums(  ${projectName}EmailTemplateEnum.values() ) );

		#if( ${projectType} == "cms" || ${projectType} == "ecommerce" ) 
			CmsConfiguration.getCmsConfiguration().registerUnconfigurableCmsAtomEnums( CmsConfiguration.getActiveUnconfigurableAtomEnums( ${projectName}UnconfigurableAtomEnum.values() ) );
		#end
			return true;
		}

		return false;
	}
	

	public static ${projectName}Configuration get${projectName}Configuration() {
		return (${projectName}Configuration) getModuleConfiguration( ${projectName}Configuration.class );
	}

	@Override
	public ModuleConfiguration getModuleConfiguration() {
		return ${projectName}Configuration.get${projectName}Configuration();
	}
}
