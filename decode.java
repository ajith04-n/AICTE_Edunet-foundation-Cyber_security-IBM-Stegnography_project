import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

public class decode {
    public static void main(String[] args) throws Exception {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select the Encrypted Image");
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

        File passwordFile = new File(imageFile.getParent(), "password.txt");
        if (!passwordFile.exists()) {
            System.out.println("Error: Password file not found!");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(passwordFile));
        String storedPassword = reader.readLine().trim();
        reader.close();

        String inputPassword = JOptionPane.showInputDialog("Enter passcode for decryption:");
        if (!storedPassword.equals(inputPassword)) {
            System.out.println("ERROR: Incorrect passcode!");
            return;
        }

        Color c = new Color(img.getRGB(0, 0));
        int msgLen = c.getRed() + (c.getGreen() * 256);

        byte[] msgBytes = new byte[msgLen];
        int index = 0;
        outer:
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                if (x == 0 && y == 0) continue;

                Color pixel = new Color(img.getRGB(x, y));
                if (index < msgLen) msgBytes[index++] = (byte) pixel.getRed();
                if (index < msgLen) msgBytes[index++] = (byte) pixel.getGreen();
                if (index < msgLen) msgBytes[index++] = (byte) pixel.getBlue();
                if (index >= msgLen) break outer;
            }
        }

        String message = new String(msgBytes, "UTF-8");
        System.out.println("Decoded Message: " + message);
    }
}
