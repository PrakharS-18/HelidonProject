CREATE DATABASE ECOM;

CREATE TABLE PRODUCTCATEGORY(
                                PRODUCTCATEGORYID INT PRIMARY KEY AUTO_INCREMENT,
                                NAME VARCHAR(255) UNIQUE
);

CREATE TABLE PRODUCTSUBCATEGORY(
                                   PRODUCTSUBCATEGORYID INT PRIMARY KEY AUTO_INCREMENT,
                                   PRODUCTSUBCATEGORYNAME VARCHAR(255) UNIQUE ,
                                   PRODUCTSUBCATEGORYDESCRIPTION VARCHAR(255) ,
                                   PCAT_ID INT ,
                                   FOREIGN KEY (PCAT_ID) REFERENCES PRODUCTCATEGORY (PRODUCTCATEGORYID)
);

CREATE TABLE PRODUCT(
                        PRODUCTID INT PRIMARY KEY ,
                        PRODUCTNAME VARCHAR(255) UNIQUE ,
                        PRODUCTDESCRIPTION VARCHAR(255) ,
                        PRODUCTPRICE INT ,
                        IMAGEFILEPATH VARCHAR(255) ,
                        PSUBCAT_ID INT ,
                        FOREIGN KEY (PSUBCAT_ID) REFERENCES PRODUCTSUBCATEGORY (PRODUCTSUBCATEGORYID)
);

alter table product
    add productSubCategory varchar(255) not null;