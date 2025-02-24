import cv2
import os
import tkinter as tk
from tkinter import filedialog

def select_image():
    root = tk.Tk()
    root.withdraw()
    file_path = filedialog.askopenfilename(title="Select the Encrypted Image", filetypes=[("Image Files", "*.png")])
    return file_path
image_path = select_image()
if not image_path:
    print("No image selected. Exiting...")
    exit()
img = cv2.imread(image_path)
if img is None:
    print("Error: Unable to load the image.")
    exit()
password_file = os.path.join(os.path.dirname(image_path), "password.txt")
if not os.path.exists(password_file):
    print("Error: Password file not found!")
    exit()

with open(password_file, "r") as f:
    stored_password = f.read().strip()
pas = input("Enter passcode for decryption: ")

if pas != stored_password:
    print("ERROR: Incorrect passcode!")
    exit()
msg_length = int(img[0, 0, 0]) + (int(img[0, 0, 1]) * 256)
message_bytes = []
index = 0
for row in range(img.shape[0]):
    for col in range(img.shape[1]):
        for color in range(3):
            if row == 0 and col == 0:
                continue 
            if index < msg_length:
                message_bytes.append(int(img[row, col, color])) 
                index += 1
            else:
                break
        if index >= msg_length:
            break
    if index >= msg_length:
        break
message = bytes(message_bytes).decode('utf-8', errors='ignore')
print("Decrypted message:", message)