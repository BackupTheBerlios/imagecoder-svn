
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


/**
 *  TextToPng
 
    This program is free software; you can redistribute it and/or modify it under the terms
    of the GNU General Public License as published by the Free Software Foundation; either
    version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
    without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with this program;
    if not, see <http://www.gnu.org/licenses/>.
 *
 */
class ImageCoder {
 
	private static String mode = null;
	private static String text = null;
	private static String image = null;
	
    static public void main(String[] args) throws IOException{
       
    	init(args);
        
    	if("en".equalsIgnoreCase(mode)){
    		encode();
    	}
    	else if ("de".equalsIgnoreCase(mode)){
    		System.out.println(decode());   		
    	}
    	
   }
    
    private static String decode() throws IOException{
		ImageDecoder decode = new ImageDecoder(image);
		return decode.decode();
    }
    
    private static void encode() throws IOException{
    	ImageEncoder encoder = null;
    	if(image != null){
    		encoder = new ImageEncoder(image);
    	}
    	else{
    		encoder = new ImageEncoder();
    	}
    	BufferedImage image = encoder.encode(text);                   
        ImageIO.write(image, "png", new File("image.png"));  	
    }
    
    private static void init(String[] args){
    	for(int i=0;i<args.length;i++){
    		if(args[i].startsWith("m=")){
    			mode = args[i].substring(2);
    		}
    		else if(args[i].startsWith("i=")){
    			image = args[i].substring(2);
    		}
    		else if(args[i].startsWith("s=")){
    			text = args[i].substring(2);
    		}
    	}
    }
}