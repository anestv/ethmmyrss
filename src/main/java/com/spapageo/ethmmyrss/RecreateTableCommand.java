/**
 * 
 */
package com.spapageo.ethmmyrss;

import net.sourceforge.argparse4j.inf.Namespace;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.cli.EnvironmentCommand;
import com.yammer.dropwizard.config.Environment;

/**
 * @author Doom
 *
 */
public class RecreateTableCommand extends EnvironmentCommand<ThmmyRssConfiguration>{
	private ThmmyRssService service;
	
	protected RecreateTableCommand(Service<ThmmyRssConfiguration> serv,
			String name, String description) {
		super(serv, name, description);
		this.service = (ThmmyRssService)serv; 
	}

	@Override
	protected void run(Environment env, Namespace arg1,
			ThmmyRssConfiguration config) throws Exception { 

	    service.getDao().droptable();
	    service.getDao().createItemsTable();
	}
}
