uCracker
==========

A very simple java programm that [sniffs](http://en.wikipedia.org/wiki/Packet_analyzer) the network and displays displays passwords of many sites that deliver their data without any encoding. 

This implementation uses the [<code>jpcap</code>](http://sourceforge.net/projects/jpcap/) lib, provided by [SourceForce](http://sourceforge.net/). 
Besides, <code>jpcap</code> uses the [<code>libpcap</code>](http://www.tcpdump.org/) library, that must be installed and well configured to work.

Project structure
-----------------

The project is structured by branchs in this way:

* <code>master</code>: Contains the current code of the application under development.
* <code>UI-Dev</code>: Containt the current code of the web UI of the application under development.
* <code>Release\_\*</code>: Contains the code of the application released, this is, a stable version. (**The first one hasn't been released yet.**)
* <code>gh-pages</code>: Contains the code of the web UI deployed with GitHub Pages in http://farolfo.github.io/uCracker. (__Still under development.__)


Application overview
--------------------

Please checkout the application overview at http://farolfo.github.io/uCracker.


