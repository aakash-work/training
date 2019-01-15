#! /usr/bin/python3
 
import requests
from bs4 import BeautifulSoup
import os
import datetime
 
dt = datetime.datetime.now()
#import pdb;pdb.set_trace()
cd = str(dt.year)+'0'+str(dt.month)+str(dt.day)
os.makedirs('Bing',exist_ok=True)
url = 'http://bingwallpaper.com/' 
sc = requests.get(url)
soup = BeautifulSoup(sc.text,'lxml')
image = soup.select('.cursor_zoom img')
image_url = image[0].get('src')
res = requests.get(image_url)
with open(os.path.join('Bing',cd+'.jpg'),'wb') as file:
    file.write(res.content) 
#os.system('gsettings set org.gnome.desktop.background picture-uri http://file:///home/radioactive/Bing/'+cd+'.jpg')
import subprocess
#picture_path='/home/MIQDIGITAL/ashutosh/mediaiq_codes/secrets_pems/Bing/'+cd+'.jpg'
picture_path=os.path.join('Bing',cd+'.jpg')
#subprocess.Popen("DISPLAY=:0 GSETTINGS_BACKEND=dconf /usr/bin/gsettings set org.gnome.desktop.background picture-uri file://{0}".format(picture_path), shell=True)
print(picture_path)

os.system("/usr/bin/gsettings set org.gnome.desktop.background picture-uri "+ os.getcwd() + "/" + picture_path)
print("Wallpaper set")