package org.uCracker.util;

import net.sourceforge.jpcap.capture.PacketListener;
import net.sourceforge.jpcap.net.Packet;

public interface uCrackerPacketListener extends PacketListener{

	public void packetArrived(Packet packet);

	public String getHost();

}
