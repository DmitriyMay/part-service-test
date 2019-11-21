Requirements: JRE 1.8, Maven 3, tomcat over 8

•	Download the project from the repository

•	Add dependency "postgresql-42.2.8.jar" to "WEB-INF/lib"

•	In the file "src\main\resources\db.properties" specify the parameters for connecting to the database
•	Go to the root of the project and execute the “mvn package”
•	WAR archive should be placed in the "webapp" directory where tomcat is located
•	Run tomcat "startup.bat/sh"
•	Follow the link "http://localhost: 8080/".

Or
•	Open a project in Ide (IntelliJ IDEA)
•	Add configuration, select "Tomcat Server -> Local"
•	Add dependency "postgresql-42.2.8.jar" to "WEB-INF/lib"
•	In the file "src\main\resources\db.properties" specify the parameters for connecting to the database
•	Run “Fix”, go to “Deployment” and delete “Application Context”.
•	Run
