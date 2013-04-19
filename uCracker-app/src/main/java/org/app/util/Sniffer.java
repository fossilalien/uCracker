package org.app.util;

import net.sourceforge.jpcap.capture.CaptureDeviceNotFoundException;
import net.sourceforge.jpcap.capture.CaptureDeviceOpenException;
import net.sourceforge.jpcap.capture.CapturePacketException;
import net.sourceforge.jpcap.capture.InvalidFilterException;
import net.sourceforge.jpcap.capture.PacketCapture;
import net.sourceforge.jpcap.capture.PacketListener;

import org.apache.log4j.Logger;
import org.app.IOLPacketListener;

public class Sniffer {

	/* Mr. developer:
	 * 
	 *  If you want to use this class in your app, you should modify the following variables if needed:
	 *  
	 *  > HOST : Filter your host of interest.
	 *  > Implement a PacketListener, and initailizated in the Sniffer constructor. This will analyze each packet the sniffer catches.
	 *  > In method 'sniff(String inet)', modify the 'snaplen' and 'timeout' parameters of the jpcap.open(...) call as you need them.
	 *  
	 *  */
	
	private static final Logger LOG = Logger.getLogger(Sniffer.class);
		
	private static final int INFINITE = -1;
	private static final int PACKET_COUNT = INFINITE;
	
	private static final String HOST = "itba.edu.ar";
	private static final String FILTER = "host " + HOST + " and ip and tcp and port 80";

	PacketCapture pcap;
	PacketListener packetListener;
	
	public Sniffer(ArgsPresentator argsPresentator){
		pcap = new PacketCapture();
		packetListener = new IOLPacketListener(argsPresentator);
	}

	public void setInterface(String inet) throws CaptureDeviceNotFoundException {
	}

	/***
	 * Sniffs the given interface
	 * @param inet
	 * @throws CaptureDeviceNotFoundException 
	 * @throws CaptureDeviceOpenException 
	 * @throws InvalidFilterException 
	 * @throws CapturePacketException 
	 * @throws Exception
	 */
	public void sniff(String inet) throws CaptureDeviceNotFoundException, CaptureDeviceOpenException, InvalidFilterException, CapturePacketException {
		if(inet == null){
			inet = pcap.findDevice();
		}
		// Initialize jpcap
		LOG.trace("Using device '" + inet + "'");
		pcap.open(inet, 4000, true, 5000);
		pcap.setFilter(FILTER, true);
		pcap.addPacketListener(packetListener);
		LOG.trace("Capturing packets...");
		pcap.capture(PACKET_COUNT);
	}

}