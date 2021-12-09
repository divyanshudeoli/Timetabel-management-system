package source;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class calculateBlockHash{
	public String hash;
	public calculateBlockHash(String message,String algo){
	        StringBuffer buffer = new StringBuffer();
	        try{
	            	MessageDigest md = MessageDigest.getInstance(algo);
	            	md.update(message.getBytes());
	              byte[] bytes= md.digest(); 
	              for(byte b : bytes)
	                buffer.append(String.format("%02x", b));
	        }
	        catch(NoSuchAlgorithmException ex){ System.out.println(ex);}
	    hash=buffer.toString();
	    }
	}