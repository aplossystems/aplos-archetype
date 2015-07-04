package com.aplos.${artifactId}.module;

import java.io.IOException;

import javax.servlet.ServletContextEvent;

import org.xhtmlrenderer.pdf.ITextRenderer;


#if( ${projectType} == "cms" || ${projectType} == "ecommerce" )


import com.aplos.cms.module.CmsModule;
#end
#if( ${projectType} == "ecommerce" )
import com.aplos.ecommerce.module.EcommerceModule;
#end
import com.aplos.${artifactId}.module.${projectName}Module;
import com.aplos.common.AplosUrl;
import com.aplos.common.BackingPageUrl;
import com.aplos.common.ThemeManager;
import com.aplos.common.appconstants.AplosScopedBindings;
import com.aplos.common.beans.SystemUser;
import com.aplos.common.beans.Website;
import com.aplos.common.listeners.AplosContextListener;
import com.aplos.common.module.CommonModule;
import com.aplos.common.module.CommonModuleDbConfig;
import com.aplos.common.tabpanels.SiteTabPanel;
import com.aplos.common.templates.PrintTemplate;
import com.aplos.common.utils.CommonUtil;
import com.aplos.common.utils.JSFUtil;
import com.lowagie.text.DocumentException;

public class ContextListener extends AplosContextListener {
	
	public ContextListener() {
		super();
		setImplementationModule( new ${projectName}Module() );
		addAplosModule( getImplementationModule() );
	#if( ${projectType} == "ecommerce" ) 
		addAplosModule( new EcommerceModule() );
	#end
	#if( ${projectType} == "cms" || ${projectType} == "ecommerce" ) 
		addAplosModule( new CmsModule() );
	#end
		CommonModule aplosCommonModule = new CommonModule();
//		CommonModuleDbConfig commonModuleDbConfig = (CommonModuleDbConfig) aplosCommonModule.getModuleDbConfig();
//		commonModuleDbConfig.setCurrencyUsed(true);
		addAplosModule( aplosCommonModule );
	}

	@Override
	public void contextInitialized() {
		super.contextInitialized();
		getContext().setAttribute( CommonUtil.getBinding( SiteTabPanel.class ), new SiteTabPanel(this));
	}

	@Override
	public String getDefaultTheme() {
		return ThemeManager.RESPONSIVE;
	}
}
