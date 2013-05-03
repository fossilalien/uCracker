package org.uCracker.util;

import net.sourceforge.jpcap.capture.PacketListener;

public interface uCrackerPacketListener {

	public PacketListener getPacketListener();

	public String getHost();

}
