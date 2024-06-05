import pyautogui
import pyperclip
import time

isFirstExe=True

filePath="C:/Users/it232231.TSITCL/AndroidStudioProjects/wantouch_project/app/src/main/java/com/example/wantouch_project/MainActivity.java"
prevContent=""
while True:
    file=open(filePath,'r',encoding='utf-8')
    content=file.read()
    file.close()
    if(prevContent!=content):
        prevContent=content
        pyautogui.hotkey('shiftright', 'f10')
        time.sleep(2)
        pyautogui.hotkey('altright','f12')
        if isFirstExe:
            isFirstExe=False
        else:
            pyautogui.hotkey('altright','f12')
    time.sleep(1)