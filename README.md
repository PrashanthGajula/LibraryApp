# LibraryApp

THe library App has a 
- login page, 
- User registration page,
- Avaiable Books page, 
- Book Request page.

mySQL Database.

1. desc lib_users;

uid	int(11)	NO	PRI		auto_increment
userName	varchar(45)	NO	UNI		
password	varchar(45)	NO			
fName	varchar(45)	YES			
lName	varchar(45)	YES			
age	int(11)	YES			
admin	varchar(5)	NO			

2. desc category;

cid	int(11)	NO	PRI		auto_increment
category_desc	varchar(45)	NO	UNI		


3. desc book;

bid	int(11)	NO	PRI		auto_increment
cid	int(11)	NO	MUL		
book_desc	varchar(45)	NO			
quantity	int(11)	YES			
