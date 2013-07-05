package org.uCracker.util;

import java.util.LinkedList;
import java.util.List;

import net.sourceforge.jpcap.capture.CaptureDeviceNotFoundException;
import net.sourceforge.jpcap.capture.CaptureDeviceOpenException;
import net.sourceforge.jpcap.capture.CapturePacketException;
import net.sourceforge.jpcap.capture.InvalidFilterException;
import net.sourceforge.jpcap.capture.PacketCapture;
import net.sourceforge.jpcap.capture.PacketListener;

import org.apache.log4j.Logger;

public class Sniffer {
	
	private static final Logger LOG = Logger.getLogger(Sniffer.class);
		
	private static final int INFINITE = -1;
	private static final int PACKET_COUNT = INFINITE;
	
	private static String filter = "ip and tcp and port 80";

	PacketCapture pcap;
	List<PacketListener> packetListeners;
	
	public Sniffer(ArgsPresentator argsPresentator){
		pcap = new PacketCapture();
		packetListeners = new LinkedList<PacketListener>();		
	}
	
	public void addHostFilters(List<String> hosts){
		StringBuffer sb = new StringBuffer();
		sb.append(filter);
		sb.append(" and ( ");
		int i = 0;
		for(String host : hosts){
			sb.append("host ");
			sb.append(host);
			if( i != hosts.size()-1 ){
				sb.append(" or ");
			}
			i++;
		}
		sb.append(" )");
		filter = sb.toString();
	}
	
	public void addPacketListener(PacketListener packetListener){
		pcap.addPacketListener(packetListener);
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
		pcap.setFilter(filter, true);
		for(PacketListener packetListener : packetListeners){
			pcap.addPacketListener(packetListener);
		}
		LOG.trace("Capturing packets...");
		pcap.capture(PACKET_COUNT);
	}

}