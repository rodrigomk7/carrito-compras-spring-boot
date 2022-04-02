-- INSERT INTO productos (descripcion, precio,stock) VALUES ("Hamburguesa",5.50,10),("Milanesa",4.50,15);

-- informacion de clientes 

INSERT INTO clientes (nombre, apellido,email,fecha_creacion) VALUES ('Lionel','Messi', 'lionelmessi@gmail.com', '2021-07-30');

INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('Lg monitor', 1500, NOW(), 12, 'a.png');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('Ducati monitor', 1700, NOW(), 7, 'aa.jpg');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('samsung monitor', 1900, NOW(),3, 'a.png');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('TCLmonitor', 2300, NOW(), 23, 'aa.jpg');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('Aranda', 1500, NOW(), 10, 'a.png');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('Lentes', 500, NOW(), 30, 'a.png');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('Teclado', 100, NOW(), 1, 'aa.jpg');
INSERT INTO productos (descripcion,precio,fecha_creacion, stock , URLImagen) VALUES ('Notebook', 15500, NOW(), 4, 'a.png');

-- INSERT INTO carritos (descripcion, observacion,fecha_creacion,cliente_id) VALUES ('Lionel','Messi', 'lionelmessi@gmail.com', );
-- INSERT INTO carritos_items (cantidad, carrito_id, producto_id) VALUES (2,2,1 );
-- INSERT INTO carritos_items (cantidad, carrito_id, producto_id) VALUES (3,2,4 );