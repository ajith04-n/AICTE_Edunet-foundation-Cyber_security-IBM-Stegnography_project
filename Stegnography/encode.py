import cv2
import os
import tkinter as tk
from tkinter import filedialog

def select_image():
    root = tk.Tk()
    root.withdraw()
    file_path = filedialog.askopenfilename(title="Select an Image", filetypes=[
        ("All Image Files", "*.png *.jpg *.jpeg *.bmp *.tiff"),
        ("PNG", "*.png"), ("JPEG", "*.jpg *.jpeg"), ("BMP", "*.bmp"), ("TIFF", "*.tiff")])
    return file_path
image_path = select_image()
if not image_path:
    print("No image selected. Exiting...")
    exit()
img = cv2.imread(image_path)
if img is None:
    print("Error: Unable to load the image.")
    exit()
msg = input("Enter secret message: ")
password = input("Enter a passcode: ")
msg_bytes = msg.encode('utf-8')
msg_length = len(msg_bytes)
max_capacity = (img.shape[0] * img.shape[1] * 3) - 1
if msg_length > max_capacity:
    print("Message too long for this image!")
    exit()
img[0, 0, 0] = msg_length % 256 
img[0, 0, 1] = (msg_length // 256) % 256
index = 0
for row in range(img.shape[0]):
    for col in range(img.shape[1]):
        for color in range(3):
            if row == 0 and col == 0:
                continue 
            if index < msg_length:
                img[row, col, color] = int(msg_bytes[index])
                index += 1
            else:
                break
        if index >= msg_length:
            break
    if index >= msg_length:
        break
encrypted_image_path = os.path.join(os.path.dirname(image_path), "encryptedImage.png")
cv2.imwrite(encrypted_image_path, img)
print(f"Encrypted image saved as: {encrypted_image_path}")
password_file = os.path.join(os.path.dirname(image_path), "password.txt")
with open(password_file, "w") as f:
    f.write(password)