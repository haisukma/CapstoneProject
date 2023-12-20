import cv2
import os


folder_path = 'C:\\Users\\Firman Satria S\\Downloads\\nasi goreng'

new_width = 128
new_height = 128


for filename in os.listdir(folder_path):
    if filename.endswith('.jpg') and filename.endswith('.png') and filename.endswith('.jpeg'):
        image_path = os.path.join(folder_path, filename)
        image = cv2.imread(image_path)
        resized_image = cv2.resize(image, (new_width, new_height))
        cv2.imwrite(os.path.join(folder_path, 'resized_' + filename), resized_image)

print('Proses pengubahan dimensi selesai.')


for filename in os.listdir(folder_path):
    if filename.startswith('pic_') and (filename.endswith('.jpg') and filename.endswith('.png') and filename.endswith('.jpeg')):
        file_path = os.path.join(folder_path, filename)
        os.remove(file_path)
        print(f'{filename} dihapus.')

print('Proses penghapusan dataset yang sebelumnya diubah dimensi selesai.')