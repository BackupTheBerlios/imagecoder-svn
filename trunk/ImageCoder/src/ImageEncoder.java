import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageEncoder {

	private BufferedImage image;
	
	public ImageEncoder(){
		
	}
	
	public ImageEncoder(BufferedImage image){
		this.image = image;
	}
	
	public ImageEncoder(String imagePath) throws IOException{
		this.image = imagePath == null ? null : ImageIO.read(new File(imagePath));
	}
	
	public BufferedImage encode(String text){
		int width = -1;
		int height = -1;
		BufferedImage baseImage = null;
		if(image == null){			
			width = height = (int)Math.ceil(Math.sqrt(text.length()));
			baseImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		else{
			width = image.getWidth();
			height = image.getHeight();
			baseImage = image;
		}
		
		double[] a = new double[3];
		WritableRaster wr = baseImage.getRaster();

		for(int textIndex=0;textIndex<text.length();textIndex++){
			int color = (int)text.charAt(textIndex);			
		}
		
		boolean eot = false;
		int textIndex = 0;
		System.out.println("Text: " + text);
        for(int i = 0; !eot && i<width; ++i) {
        	for(int j = 0; !eot && j<height; ++j) {
        		int color = (int)text.charAt(textIndex);
        		
        		if(textIndex < text.length()){
        			color = (int)text.charAt(textIndex);
        		}
           		
        		int[] pixels = null;
        		if(image != null){
        			System.out.println("Get pixels from image");
        			pixels = wr.getPixel(i, j, pixels);
        			pixels[0] = color; 
        			System.out.println("Array length " + pixels.length);
        		}
        		else{
        			pixels = new int[3];
        			pixels[0] = color;
        			pixels[1] = 50;
        			pixels[2] = 50;
        			
        		}
 
    			for(int x=0; x<pixels.length;x++){
    				System.out.print("." + pixels[x]);
    			} 
				System.out.println(".");
        		wr.setPixel(i, j, pixels);
        		
           		textIndex ++;       		
           		eot = textIndex >= text.length();
        	}
        }
		
		return baseImage;
	}
	
}
