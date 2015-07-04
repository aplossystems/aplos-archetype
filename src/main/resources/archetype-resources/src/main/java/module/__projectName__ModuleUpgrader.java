package com.aplos.${artifactId}.module;

import com.aplos.common.module.AplosModuleImpl;
import com.aplos.common.module.ModuleUpgrader;

public class ${projectName}ModuleUpgrader extends ModuleUpgrader {

	public ${projectName}ModuleUpgrader(AplosModuleImpl aplosModule) {
		super(aplosModule, ${projectName}Configuration.class);
	}

	@Override
	public void upgradeModule() {

		//don't use break, allow the rules to cascade
		switch (getMajorVersionNumber()) {
			case 1:

				switch (getMinorVersionNumber()) {
					case 0:
						switch (getPatchVersionNumber()) {
							case 0:
						}
				}
		}
	}

}




