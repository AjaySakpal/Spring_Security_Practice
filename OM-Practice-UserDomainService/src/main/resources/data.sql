INSERT INTO User_Details (user_Id,user_Name,mobile_No,email_Id) VALUES (1,'Ajay','9867564754','asdfg.com'),(2,'Chikita','9998987678','vjhaw.com'),(3,'Akshu','89098897678','yqtad.com');
INSERT INTO Business (b_Name,b_Description,user_Id) VALUES ('Cafe','The Cafe',2),('Shop','The Shop',1),('Hotel','The Hotel',3);
INSERT INTO Business_Package (package_Id,package_Name) VALUES (1,'Basic'),(2,'Advance'),(3,'Premium');
INSERT INTO Business_Features (ft_Id,feature) VALUES (1,'Live_Profile'),(2,'Menu_List'),(3,'Online_Orders_Only'),(4,'Online_Orders_&_Delivery'),(5,'Payment_Gateway');
INSERT INTO featuretopackagemapping (ft_Id,package_Id) VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,2),(3,3),(4,2),(4,3),(5,3);