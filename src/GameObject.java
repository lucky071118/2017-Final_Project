import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class GameObject {
	
	//object coordinates  
	protected int x;
    protected int y;
    
    //object width and height
    protected int width;
    protected int height;
    
    //whether object is visible or not
    protected boolean isVisible;
    
    //image of object 
    protected Image image;
    
    public GameObject(int x, int y) {
    	this.x = x;
    	this.y = y;
    	isVisible =true;
    }
    
    protected void loadImage(String imageName){
        ImageIcon imageIcon = new ImageIcon(imageName);
        image = imageIcon.getImage();
    }
    
    protected void getImageDimensions(){
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    
    public Image getImage() {
        return image;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean isVisible() {
        return isVisible;
    }
    
    public void setVisible(Boolean visible) {
    	isVisible = visible;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
    
    
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
}
