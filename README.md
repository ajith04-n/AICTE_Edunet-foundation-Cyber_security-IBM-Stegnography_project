# 🕵️‍♂️ Steganography – Hidden Message Encoder & Decoder

**Steganography** is the art of concealing secret information within a non-secret file or image — a fascinating blend of creativity and cybersecurity.
This project demonstrates a simple yet powerful **Java-based implementation** of steganography that allows you to **hide secret messages inside images** and later **retrieve them securely**.

---

## 🚀 Features

### 🔐 1. Message Encoding

* Embed secret text messages inside image files.
* Password-protected encoding for enhanced security.
* Supports `.jpg` and `.png` formats.

### 🧩 2. Message Decoding

* Retrieve hidden messages from encoded images.
* Password verification required for successful decryption.
* Error handling for incorrect passwords or tampered images.

### 💾 3. File Management

* Works with image and password files stored locally.
* Generates new output images with embedded data.

### ⚙️ 4. Simple Java Implementation

* Pure Java approach — no external libraries required.
* Includes **two main classes**:

  * `encode.java` → For embedding secret messages.
  * `decode.java` → For extracting hidden text.

---

## 📂 Project Structure

```
├── encode.java       # Program to encode secret text into image
├── decode.java       # Program to decode hidden message from image
├── mypic.jpg         # Sample input image
├── password.txt      # Stores password for encryption/decryption
└── README.md         # Project documentation
```

---

## 🧰 Technology Stack

| Component    | Description                  |
| ------------ | ---------------------------- |
| **Language** | Java (JDK 8 or later)        |
| **IDE**      | VS Code / Eclipse / IntelliJ |
| **Platform** | Command Line / Terminal      |
| **Security** | Password-based protection    |

---

## 🛠️ Getting Started

### ✅ Prerequisites

Ensure you have the following installed before running the project:

* Java 8 or higher
* Text editor or IDE (Eclipse, IntelliJ, or VS Code)
* Command-line terminal access

---

## 💡 Usage Guide

### 1️⃣ Compile the Programs

```bash
javac encode.java
javac decode.java
```

### 2️⃣ Encode a Message

```bash
java encode mypic.jpg "YourSecretMessage" output.png
```

✅ This command hides your message in the image and generates `output.png`.

### 3️⃣ Decode the Message

```bash
java decode output.png
```

🔓 Displays the hidden message in your terminal after password verification.

---

## 🔒 Security Measures

* Uses **password-based authentication** stored in `password.txt`.
* Prevents unauthorized decoding of sensitive messages.
* Keep your password file safe for future access.

---

## 🎯 Applications

* Secure communication over public channels
* Digital watermarking
* Copyright and intellectual property protection
* Confidential data transmission

---

## 🔮 Future Scope

* Support for audio and video steganography
* GUI-based interface for user interaction
* Encryption of messages before embedding
* Cloud-based secure storage and retrieval

---

## 👨‍💻 Author

Developed as part of the **AICTE Edunet Foundation Cyber Security - IBM Project**.

> A practical demonstration of combining **security**, **creativity**, and **Java programming**.
