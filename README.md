Steganography Project 🕵️‍♂️🔐

This project demonstrates steganography, the art of hiding secret information inside an image. It allows you to encode a hidden message into an image and later decode it back using Java.

🚀 Features

Hide secret text messages inside an image.

Retrieve the hidden message from the image.

Simple Java implementation with two main files:

encode.java – For embedding text into an image.

decode.java – For extracting hidden text from the image.

Example image (mypic.jpg) provided for testing.

Password-based security (password.txt).

📂 Project Structure
├── encode.java       # Java program to encode message into image
├── decode.java       # Java program to decode hidden message
├── mypic.jpg         # Sample image for testing
├── password.txt      # Stores password for encoding/decoding
└── README.md         # Project documentation

⚙️ Requirements

Java 8 or later

IDE or text editor (IntelliJ, Eclipse, VS Code, etc.)

Command line or terminal access

🔧 Usage
1. Compile the programs
javac encode.java
javac decode.java

2. Encode a message
java encode mypic.jpg "YourSecretMessage" output.png


This will create output.png containing the hidden message.

3. Decode the message
java decode output.png


You will see the hidden message displayed in the terminal.

🔒 Security

A password (password.txt) is used to add an extra layer of security during encoding/decoding.

Ensure that the password file is kept safe.

🎯 Applications

Secure message transmission

Watermarking

Digital rights management

Protecting sensitive information

👨‍💻 Author

Developed as part of AICTE Edunet Foundation Cyber Security - IBM Project.
