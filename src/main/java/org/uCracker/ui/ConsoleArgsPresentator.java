package org.uCracker.ui;

import org.uCracker.util.ArgsPresentator;

public class ConsoleArgsPresentator implements ArgsPresentator{

	private static final String LINE = "-----------------------------------------------------------------------";
	
	private static final String VERSION = "v1.0";
	
	public void init() {                           
		System.out.println(LINE);
		System.out.println("--       uCracker "+ VERSION +" - the universal cracker for web applications !");
		System.out.println(LINE);
		System.out.println("---");
		System.out.println("--       Remember, this is not a malware application, my goal here");
		System.out.println("--    is to show you why YOU MUST CHANGE YOUR PASS PERIODICALLY !!");
		System.out.println("--    and DON'T REPEAT PASS BETWEEN YOUR ACCOUNTS  !!\n---");
		System.out.println("--       Also remember that this are ATTEMPTS that a user does ");
		System.out.println("--    to some web sites, so some of this passwords might be wrong if the user ");
		System.out.println("--    that has typed it did it wrong.\n---");
		System.out.println("---\n--\t The results will be displaied as ");
		System.out.println("--\t\t\t(host) \t'dni' | 'password' \n--");
		System.out.println(LINE);
	}
	
	public void display(String dni, String pwd, String host) {
		System.out.println(" ("+host+") \t'" + dni + "' | '" + pwd + "'");
	}
}
