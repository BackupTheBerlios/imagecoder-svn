import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageDecoder {

	private BufferedImage image;
	
	public ImageDecoder(BufferedImage image){
		this.image = image;
	}
	
	public ImageDecoder(String imagePath) throws IOException{
		this.image = ImageIO.read(new File(imagePath));
	}
	
	public String decode(){
		WritableRaster wr = image.getRaster();
    	int height = wr.getHeight();
    	int width = wr.getWidth();
    	
    	String text = "";
    	
    	int[] pixel = null;
    	
        for(int i = 0; i<width; ++i) {
        	for(int j = 0; j<height; ++j) {
        		pixel = wr.getPixel(i, j, pixel);
        		text += (char) pixel[0];
        	}
        }
        return text;
	}
	
}
