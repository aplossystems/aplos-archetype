package com.aplos.${artifactId}.module;

import com.aplos.common.module.AplosModuleImpl;
import com.aplos.common.module.ModuleDbConfig;
import com.aplos.common.persistence.PersistentApplication;

public class ${projectName}ModuleDbConfig extends ModuleDbConfig {

	public ${projectName}ModuleDbConfig( AplosModuleImpl aplosModule ) {
		super(aplosModule);
	}

	@Override
	public void addAnnotatedClass(PersistentApplication persistentApplication) {
    	persistentApplication.addPersistentClass( ${projectName}Configuration.class, true );
	}
}