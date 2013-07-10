![uCracker](/utils/img/uCracker-logo.png)
==========

A very simple java programm that [sniffs](http://en.wikipedia.org/wiki/Packet_analyzer) the network and displays passwords of many sites that deliver their data without any encoding. 

The only thing you have to do is specify what do you want to sniff, by writting a VERY SIMPLE parser (a java class) and run this application in your computer. Later on you will see the credentials that are delivered in the network without encoding.

This implementation uses the [<code>jpcap</code>](http://sourceforge.net/projects/jpcap/) lib, provided by [SourceForce](http://sourceforge.net/). 
Besides, <code>jpcap</code> uses the [<code>libpcap</code>](http://www.tcpdump.org/) library, that must be installed and well configured to work.

Project structure
-----------------

The project is structured by branchs in this way:

* <code>master</code>: Contains the current code of the application under development.
* <code>UI-Dev</code>: Containt the current code of the web UI of the application under development.
* <code>Release\_\*</code>: Contains the code of the application released, this is, a stable version. (**The first one hasn't been released yet.**)
* <code>gh-pages</code>: Contains the code of the web UI deployed with GitHub Pages in http://farolfo.github.io/uCracker. (__Still under development.__)

Build and run
-------------

In order to build the project you have to run the command

	$ mvn clean
	$ mvn compile
	
And the executable .jar will be placed in the folder <code>target/</code>.

In order to run .jar application, you have to install the libraries

* [<code>libpcap</code>](http://www.tcpdump.org/): Library that sniffs the network.
* [<code>jpcap</code>](http://sourceforge.net/projects/jpcap/): Java wrapper for the <code>libpcap</code> library.

Then you have to run

	$ java -jar target/uCracker.jar -en __interface__
	
Now you only have to wait, and you will see all the credentials that your uCracker application has registered.


Application overview
--------------------

Please checkout the application overview at http://farolfo.github.io/uCracker.


