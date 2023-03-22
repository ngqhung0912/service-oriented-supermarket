CREATE TABLE currentStock (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         product_id INT NOT NULL,
                         name VARCHAR(250) NOT NULL,
                         description VARCHAR(250) NOT NULL,
                         price DECIMAL DEFAULT NULL,
                         count INT NOT NULL
);
