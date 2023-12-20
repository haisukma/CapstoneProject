from PIL import Image
import os

directory = r'C:\Users\Firman Satria S\Downloads\nasi goreng'
c=1
for filename in os.listdir(directory):
    if filename.endswith(".jpg"):
        im = Image.open(filename)
        name='img'+str(c)+'.png'
        rgb_im = im.convert('RGB')
        rgb_im.save(name)
        c+=1
        print(os.path.join(directory, filename))
        continue
    else:
        continue