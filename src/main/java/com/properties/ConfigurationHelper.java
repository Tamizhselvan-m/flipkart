package com.properties;

import java.io.IOException;

public class ConfigurationHelper {
	private ConfigurationHelper() {
	}
	
	public static ConfigurationHelper getInstance() {
		ConfigurationHelper ch = new ConfigurationHelper();
		return ch;
	}
	
	public static ConfigurationReader getInstanceCR() throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
	}
}
