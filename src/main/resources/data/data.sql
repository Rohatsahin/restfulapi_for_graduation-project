--password : 12345
INSERT INTO Account (id, city, district, email, first_name, last_name, password, phone, user_role, created_date, last_modified_date, version) VALUES ('1', 'California', 'minnesota', 'omnifood@gmail.com', 'Rohat', 'Sahin', '8cb2237d0679ca88db6464eac60da96345513964', '09008006092', 'User', NOW(), NULL, 0);
INSERT INTO Restaurant (restaurant_id, address, city, description, district, phone_number, store_name, url) VALUES ('1', '50 Market Street, San Francisco, California 94103, United States', 'Istanbul', 'Test Restaurant', 'Avcilar', '23232343432', 'Ankara OcakBası', 'http://www.naturkoy.com.tr/wp-content/uploads/2015/08/ocakbasi.jpg');
INSERT INTO Restaurant (restaurant_id, address, city, description, district, phone_number, store_name, url) VALUES ('2', '50 Market Street, San Francisco, California 94103, United States', 'Istanbul', 'Test Restaurant', 'Bakirkoy', '23232343432', 'Suruç Retaurant', 'http://mado.com.tr/storage/images/1441953857_soc.jpg');
INSERT INTO Score (id, presentation, taste, velocity, restaurant_id) VALUES ('1', '8', '7', '8', '1');
INSERT INTO Score (id, presentation, taste, velocity, restaurant_id) VALUES ('2', '6', '7', '5', '2');

