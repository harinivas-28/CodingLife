import pyperclip
import time
import sys

def type_writer(text, delay=0.1):
    for char in text:
        sys.stdout.write(char)
        sys.stdout.flush()
        time.sleep(delay)
    print()

if __name__ == "__main__":
    copied_text = pyperclip.paste()
    type_writer(copied_text)