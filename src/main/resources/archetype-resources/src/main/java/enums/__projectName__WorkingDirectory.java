package com.aplos.${artifactId}.enums;

import com.aplos.common.beans.AplosWorkingDirectory;
import com.aplos.common.interfaces.AplosWorkingDirectoryInter;
import com.aplos.common.utils.CommonUtil;

public enum ${projectName}WorkingDirectory implements AplosWorkingDirectoryInter {
	;

	private String directoryPath;
	private boolean restricted;
	private AplosWorkingDirectory aplosWorkingDirectory;

	private ${projectName}WorkingDirectory( String directoryPath, boolean restricted ) {
		this.directoryPath = directoryPath;
		this.restricted = restricted;
	}

	public String getDirectoryPath( boolean includeServerWorkPath ) {
		if( includeServerWorkPath ) {
			return CommonUtil.appendServerWorkPath( directoryPath );
		} else {
			return directoryPath;
		}
	}
	
	public boolean isRestricted() {
		return restricted;
	}
	
	

	public static void createDirectories() {
		for( ${projectName}WorkingDirectory workingDirectory : ${projectName}WorkingDirectory.values() ) {
			CommonUtil.createDirectory( workingDirectory.getDirectoryPath( true ) );
		}
	}

	public AplosWorkingDirectory getAplosWorkingDirectory() {
		return aplosWorkingDirectory;
	}

	public void setAplosWorkingDirectory(AplosWorkingDirectory aplosWorkingDirectory) {
		this.aplosWorkingDirectory = aplosWorkingDirectory;
	}
}

