package com.keyboardsamurais.maven.timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

/**
 * A Timestamp mojo for maven 2. Makes a timestamp variable available
 * in your pom.xml.
 * 
 * @author <a href="tag@gmx.de">Juan Antonio Agudo</a>
 * @goal create
 * @requiresProject
 * @threadsafe true
 * @phase validate
 * @describe Lightweight mojo to create a timestamp
 */
public class TimestampMojo extends AbstractMojo {

	/**
	 * The maven project.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	private MavenProject project;
	/**
	 * The name of the property value in which the timestamp will be stored.
	 * 
	 * @parameter default-value="timestamp"
	 */
	private String propertyName;

	/**
	 * The {@link SimpleDateFormat} pattern from which the timestamp will be
	 * formed.
	 * 
	 * @parameter default-value="dd.MM.yyyy HH:mm:ss"
	 */
	private String timestampPattern;

	public void execute() throws MojoExecutionException {
		Log log = getLog();
		SimpleDateFormat sdf = new SimpleDateFormat(timestampPattern);
		String date = null;
		try {
			date = sdf.format(new Date());
			Properties props = project.getProperties();
			props.put(propertyName, date);
		} catch (IllegalStateException e) {
			log.error("Could not convert date format pattern "+timestampPattern);
			throw e;
		}

	}

	void setProject(MavenProject project) {
		this.project = project;
	}
}
