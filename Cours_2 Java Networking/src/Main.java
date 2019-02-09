import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		URI uri = null;
		URL url = null;
		String texte = "index.html";
		URLConnection urlCon = null;
		try {
			//URL
			url = new URL("https://www.google.com/search?q=tester&ie=utf-8&oe=utf-8&client=firefox-b-ab");
			url = new URL("https","getfedora.org",-1,"/index.html");
			System.out.println("URL to String : " + url.toString()); //url to string
			System.out.println("Protocole : " + url.getProtocol()); //get protocole url ex: https,http,ftp,..
			System.out.println("Path : " + url.getPath()); //get path url ex: /index.html,/login.php,...
			System.out.println("Content : " + url.getContent()); //
			System.out.println("File : " + url.getFile()); //getFile()=getPath()+getQuery()
			System.out.println("Query : " + url.getQuery()); //?x=20&y=50 the value on url ex: (get/post/delete/..)
			System.out.println("Host : " + url.getHost()); //get host the url ex: www.google.com,...
			System.out.println("---------------------------------------------------------");
			
			//URI
			uri = new URI("https://www.google.com/search?q=tester&ie=utf-8&oe=utf-8&client=firefox-b-ab");
			System.out.println("Auth : " + uri.getAuthority()); //get host en decode a utf-8
			System.out.println("Fragment : " + uri.getFragment());
			System.out.println("Host : " + uri.getHost()); //get host url en decode a utf-8
			System.out.println("Path : " + uri.getPath()); //get path url ex: /index.html,/login.php,...
			System.out.println("Port : " + uri.getPort()); //get port url (-1==80)
			System.out.println("Query : " + uri.getQuery()); //?x=20&y=50 the value on url ex: (get/post/delete/..)
			System.out.println("Scheme : " + uri.getScheme()); //get the protocol used in ACTION attribute of of FORM tag 
			System.out.println("SchemeSpecific : " + uri.getSchemeSpecificPart());
			System.out.println("UserInfo : " + uri.getUserInfo()); //get userInfo
			System.out.println("URL is Absolute : " + uri.isAbsolute()); //check if url start with /
			System.out.println("URL is Opaque : " + uri.isOpaque()); //check if the url isAbsolute() + getSchemeSpecificPart() cannot content /
			System.out.println("---------------------------------------------------------");
			
			//URLConnection
			urlCon = url.openConnection();
			urlCon.connect();
			System.out.println("Content type : " + urlCon.getContentType());
			System.out.println("Content Encoding : " + urlCon.getContentEncoding());
			System.out.println("Content length : " + urlCon.getContentLength());
			System.out.println("Date : " + new Date(urlCon.getDate()));
			System.out.println("last Modified : " + new Date(urlCon.getLastModified()));
			System.out.println("Expiration : " + new Date(urlCon.getExpiration()));
			System.out.println("Permission : " + urlCon.getPermission());
			System.out.println("---------------------------------------------------------");
			
			//HttpURLConnection
			if(urlCon instanceof HttpURLConnection){
				HttpURLConnection httpUrl = (HttpURLConnection) urlCon;
				System.out.println("Request Method : " + httpUrl.getRequestMethod());
				System.out.println("Response Message : " + httpUrl.getResponseMessage());
				System.out.println("Response Code : " + httpUrl.getResponseCode());
				System.out.println("---------------------------------------------------------");
			}
			
			//Test Protocol
			String [] regex = {"http","https","ftp","smtp","tftp","telnet","tcp","udp","ssh"};
			String host = "https://getfedora.org";
			for(int i=0;i<regex.length;i++) {
				try {
					new URL(regex[i],host,texte);
					System.out.println(regex[i] + " Supported");
				} catch(Exception e) {
					System.out.println(regex[i] + " Not Supported");
				}
			}
			System.out.println("---------------------------------------------------------");
			
			//Get Header
			urlCon = url.openConnection();
			urlCon.connect();
			for(int i=0; ;i++) {
				String headerKey = urlCon.getHeaderFieldKey(i);
				String headerValue = urlCon.getHeaderField(i);
				if(headerKey == null && headerValue == null) break;
				System.out.println(headerKey + " : " + headerValue);
			}
			System.out.println("---------------------------------------------------------");
			
			//Get Data
			urlCon = url.openConnection();
			urlCon.connect();
			//Method1
			Reader r = new InputStreamReader(new BufferedInputStream(urlCon.getInputStream()));
			int i;
			while ((i =r.read())!= -1) {
				System.out.print((char)i);
			 }
			//Method2
			BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			String s = br.readLine();
			while (s!=null) {
				System.out.println(s);
				s = br.readLine();
			}
			 System.out.println("---------------------------------------------------------");
			 
			 //EncodeURL-DecodeURL
			 url = new URL("https://www.google.com/search?q=hello+world&ie=utf-8&oe=utf-8&client=firefox-b-ab");
			 String Link = url.toString();
			 String url_encode = URLDecoder.decode(Link,"UTF-8");
			 System.out.println(url_encode);
			 String url_decode = URLEncoder.encode(Link,"UTF-8");
			 System.out.println(url_decode);
			 System.out.println("---------------------------------------------------------");
			 
			 //InetAddresses
			 InetAddress ia = InetAddress.getByName("www.google.com");
			 
			 //get the raw IP address in a string format
			 System.out.println("HostAddress : " + ia.getHostAddress());
			 
			 //get the host name for this IP address
			 System.out.println("HostName : " + ia.getHostName());
			 
			 //get the address of the local host
			 InetAddress ia2 = InetAddress.getLocalHost();
			 System.out.println("my local address is : " + ia2.getHostAddress());
			 
			 //get an array of all the IP address for a given host name
			 InetAddress [] adds = InetAddress.getAllByName("www.google.com");
				for (int j = 0; j < adds.length; j++) {
					System.out.println(adds[j]);
				}
			 //transform hostname + address ip to string
			 System.out.println("Adresse : " + ia2.toString());
			 System.out.println("---------------------------------------------------------");
			 
			 //Networking Interface
			 Enumeration<NetworkInterface>  interfaces = NetworkInterface.getNetworkInterfaces();
			 
			 //get All local interfaces
			 while(interfaces.hasMoreElements()){
				NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
				System.out.printf("the Name is: %s%n",ni.getDisplayName());
				System.out.printf("the Name is: %s%n",ni.getName());
				Enumeration <InetAddress> inetAddresses = ni.getInetAddresses();
				for(InetAddress inetAddress : Collections.list(inetAddresses))
					System.out.printf("ip : %s%n", inetAddress);
			 }
		
			 //get All informations for Network Interfaces
			 Enumeration <NetworkInterface> eni = NetworkInterface.getNetworkInterfaces();
			 while(eni.hasMoreElements()){
		    	NetworkInterface ni = eni.nextElement();
					System.out.println("Name: "+ni.getName());
					System.out.println("Display Name: "+ni.getDisplayName());
					System.out.println("lo: "+ni.isLoopback());
					System.out.println("Active: " + ni.isUp());
					System.out.println("MTU= "+ ni.getMTU());
					System.out.println("multicast= " + ni.supportsMulticast());
					System.out.println("virtual: "+ ni.isVirtual());
					System.out.println("PointToPoint: " + ni.isPointToPoint());
					System.out.println("HardwareAddress: " + ni.getHardwareAddress());

				List<InterfaceAddress> list = ni.getInterfaceAddresses();
				Iterator <InterfaceAddress> iterator = list.iterator();				
				while(iterator.hasNext()){
					InterfaceAddress ia1 = iterator.next();
					System.out.println("Address: "+ ia1.getAddress());
					System.out.println("Network Prefix Length: " + ia1.getNetworkPrefixLength());
					System.out.println("Broadcast: " + ia1.getBroadcast());
				}
			 }
			 
			 //get Mac Address
			 InetAddress address = InetAddress.getLocalHost();
			 NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
			 byte [] mac = networkInterface.getHardwareAddress();
			 for (int j = 0; j < mac.length; j++) 
				System.out.format( "%02X%s" , mac[j] , (j < mac.length -1)? "-" : ""   );
			 System.out.println("---------------------------------------------------------");
			 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
