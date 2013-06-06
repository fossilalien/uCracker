package org.uCracker;

import java.util.LinkedList;
import java.util.List;

import net.sourceforge.jpcap.capture.CaptureDeviceNotFoundException;
import net.sourceforge.jpcap.capture.CaptureDeviceOpenException;
import net.sourceforge.jpcap.capture.CapturePacketException;
import net.sourceforge.jpcap.capture.InvalidFilterException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.uCracker.listeners.ITBAPacketListener;
import org.uCracker.ui.ConsoleArgsPresentator;
import org.uCracker.util.ArgsPresentator;
import org.uCracker.util.CommandLineParameters;
import org.uCracker.util.Sniffer;
import org.uCracker.util.uCrackerPacketListener;

public class uCracker {
	
	private static final Logger LOG = Logger.getLogger(uCracker.class);
	private static ArgsPresentator argsPresentator;
	
	public static void main(String[] args) {
		initializateLogger();
		CommandLineParameters clp = new CommandLineParameters();
		clp.load(args);
		Logger.getRootLogger().setLevel(clp.getLoggingLevel());
		
		if(clp.getFile() == null){
			argsPresentator = new ConsoleArgsPresentator();
		}

		try{
			Sniffer sniffer = new Sniffer(argsPresentator);
			
			//List<uCrackerPacketListener> packetListeners = JAXBPacketListener.load();
			List<uCrackerPacketListener> packetListeners = new LinkedList<uCrackerPacketListener>();
			packetListeners.add(new ITBAPacketListener(argsPresentator));
			
			List<String> hosts = new LinkedList<String>();
			
			for(uCrackerPacketListener pl : packetListeners){
				sniffer.addPacketListener(pl);
				hosts.add(pl.getHost());
			}
			
			sniffer.addHostFilters(hosts);
			
			argsPresentator.init();
			
			sniffer.sniff(clp.getInterface());
			
		} catch (CaptureDeviceNotFoundException i){
			LOG.error("There are no interfaces or devices detected for sniffing.");
		} catch (CaptureDeviceOpenException e) {
			LOG.error("The interface selected cannot be opened.");
		} catch (InvalidFilterException e) {
			LOG.error("The filter indicated is not valid (as user you should never see this, if you do, pleas contact us).");
		} catch (CapturePacketException e) {
			LOG.error("An error has occurred while capturing some packet.");
		} catch (UnsatisfiedLinkError e){
			StringBuilder sb = new StringBuilder();
			sb.append("You'r jpcap or libcap library is not well installed, you must have the native libraries installed for this to work. ");
			sb.append("Make shoure you have yout .dll, .jnlib or .so library in one of the following paths: ");
			sb.append(java.lang.System.getProperty("java.library.path"));
			LOG.error(sb.toString());
		} catch (Exception a){
			a.printStackTrace();
			LOG.error("An unexpected error has occurred.");
		}
 
	}
	
	private static void initializateLogger(){
		/* Logger initialization */
		ConsoleAppender consoleAppender = new ConsoleAppender();
		String PATTERN = "%d [%p] - %c - %m%n";
		consoleAppender.setLayout(new PatternLayout(PATTERN));
		consoleAppender.setThreshold(Level.TRACE);
		consoleAppender.activateOptions();
		Logger.getRootLogger().addAppender(consoleAppender);	
	}

	
}

