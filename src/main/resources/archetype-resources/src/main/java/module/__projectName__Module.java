package com.aplos.${artifactId}.module;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.aplos.${artifactId}.enums.${projectName}EmailTemplateEnum;
import com.aplos.${artifactId}.enums.${projectName}WorkingDirectory;
#if( ${projectType} == "cms" || ${projectType} == "ecommerce" )
import com.aplos.cms.beans.CmsWebsite;
import com.aplos.cms.module.CmsModule;
#end
import com.aplos.common.ImplicitPolymorphismEntry;
import com.aplos.common.ImplicitPolymorphismVariable;
import com.aplos.common.beans.AplosBean;
import com.aplos.common.beans.Country;
import com.aplos.common.beans.CreatedPrintTemplate;
import com.aplos.common.beans.Website;
import com.aplos.common.interfaces.AplosWorkingDirectoryInter;
import com.aplos.common.listeners.AplosContextListener;
import com.aplos.common.module.AplosModuleImpl;
import com.aplos.common.module.CommonConfiguration;
import com.aplos.common.module.ModuleConfiguration;
import com.aplos.common.module.ModuleDbConfig;
import com.aplos.common.module.ModuleUpgrader;
import com.aplos.common.utils.ApplicationUtil;
import com.aplos.common.utils.CommonUtil;
import com.aplos.common.utils.JSFUtil;

public class ${projectName}Module extends AplosModuleImpl {
	
	@Override
	public AplosWorkingDirectoryInter[] createWorkingDirectoryEnums() {
		${projectName}WorkingDirectory.createDirectories();
		return ${projectName}WorkingDirectory.values();
	}

	@Override
	public String getPackageDisplayName()  {
		return "${projectName}";
	}

	@Override
	public ModuleConfiguration getModuleConfiguration() {
		return ${projectName}Configuration.get${projectName}Configuration();
	}

	@Override
	public void addImplicitPolymorphismEntries(AplosContextListener aplosContextListener) {
		
	}

	@Override
	public ModuleDbConfig createModuleDbConfig() {
		return new ${projectName}ModuleDbConfig( this );
	}

	@Override
	public ModuleUpgrader createModuleUpgrader() {
		return new ${projectName}ModuleUpgrader(this);
	}

}
