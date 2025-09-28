import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

public class encode {
    public static void main(String[] args) throws Exception {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select an Image");
        int result = chooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No image selected. Exiting...");
            return;
        }

        File imageFile = chooser.getSelectedFile();
        BufferedImage img = ImageIO.read(imageFile);
        if (img == null) {
            System.out.println("Error: Unable to load the image.");
            return;
        }

        String message = JOptionPane.showInputDialog("Enter secret message:");
        String password = JOptionPane.showInputDialog("Enter a passcode:");

        byte[] msgBytes = message.getBytes("UTF-8");
        int msgLen = msgBytes.length;
        int maxCapacity = (img.getWidth() * img.getHeight() * 3) - 1;
        if (msgLen > maxCapacity) {
            System.out.println("Message too long for this image!");
            return;
        }

        // Encode message length in first pixel
        int lenLow = msgLen % 256;
        int lenHigh = (msgLen / 256) % 256;
        int rgb = img.getRGB(0, 0);
        Color c = new Color(rgb);
        Color newC = new Color(lenLow, lenHigh, c.getBlue());
        img.setRGB(0, 0, newC.getRGB());

        // Embed message bytes
        int index = 0;
        outer:
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                if (x == 0 && y == 0) continue; // skip first pixel

                int pixel = img.getRGB(x, y);
                Color original = new Color(pixel);
                int r = (index < msgLen) ? msgBytes[index++] : original.getRed();
                int g = (index < msgLen) ? msgBytes[index++] : original.getGreen();
                int b = (index < msgLen) ? msgBytes[index++] : original.getBlue();

                img.setRGB(x, y, new Color(r, g, b).getRGB());
                if (index >= msgLen) break outer;
            }
        }

        // Save image
        File output = new File("encoded_image.png");
        ImageIO.write(img, "png", output);

        // Save password
        FileWriter fw = new FileWriter("password.txt");
        fw.write(password);
        fw.close();

        System.out.println("Message embedded successfully!");
    }
}
