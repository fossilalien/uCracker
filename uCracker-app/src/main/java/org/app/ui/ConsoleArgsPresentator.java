package org.app.ui;

import org.app.util.ArgsPresentator;

public class ConsoleArgsPresentator implements ArgsPresentator{

	private static final String LINE = "-----------------------------------------------------------------------";
	
	private static final String VERSION = "v1.0";
	
	public void init(){	
		System.out.println("\n_____________________       ______  __            ______              ");
		System.out.println(" ____  _/_  __ \\__  /       ___  / / /_____ _________  /______________");
		System.out.println("  __  / _  / / /_  /        __  /_/ /_  __ `/  ___/_  //_/  _ \\_  ___/");
		System.out.println("___/ /  / /_/ /_  /___      _  __  / / /_/ // /__ _  ,<  /  __/  /    ");
		System.out.println(" /___/  \\____/ /_____/      /_/ /_/  \\__,_/ \\___/ /_/|_| \\___//_/ "+ VERSION);
		                                                                    
		System.out.println(LINE);
		System.out.println("--       IOL Hacker "+ VERSION +" - the ITBA sniffer application !");
		System.out.println(LINE);
		System.out.println("---");
		System.out.println("--       Remember, this is not a malware application, my goal here");
		System.out.println("--    is to show you why YOU MUST CHANGE YOUR PASS PERIODICALLY !!");
		System.out.println("--    and DON'T REPEAT PASS BETWEEN YOUR ACCOUNTS  !!\n---");
		System.out.println("--       Also remember that this are ATTEMPTS that a user does ");
		System.out.println("--    to IOL, so some of this passwords might be wrong if the user ");
		System.out.println("--    that has typed it did it wrong.\n---");
		System.out.println("---\n--\t The results will be displaied as ");
		System.out.println("--\t\t\t 'dni' | 'password' \n--");
		System.out.println(LINE);
	}
	
	public void display(String dni, String pwd){
		System.out.println(" '" + dni + "' | '" + pwd + "'");
	}
}
