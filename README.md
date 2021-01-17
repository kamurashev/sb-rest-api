<h1>SbringBoot REST example application</h1>
  <h3> &emsp; Represents simple users API</h3>

<br>

<h2>Works with MySQL DB Server version	5.7.32</h2>
  <h3> &emsp; In order to set up DB and test data:</h3>
    <p> &emsp;&emsp; 1 Execute:</p>
    <p> &emsp;&emsp; mysql -uroot -e "create database sbApp" -p</p>  
    <p> &emsp;&emsp; 2 Execute:</p>
    <p> &emsp;&emsp; mysql -u root sbApp < path_to_init.sql -p</p>

<br>

<h2>Import project, build and enjoy ;)...</h2>

  <h3> &emsp; App benefits from SpringBoot actuator so all the monitoring endpoints available </h3>
    <p> &emsp; &emsp; E.g. <a href="http://localhost:8080/actuator/health/">http://localhost:8080/actuator/health</a> checks if app is up</p>
    <p> &emsp; &emsp; E.g. <a href="http://localhost:8080/actuator/">http://localhost:8080/actuator</a> lists all the actuator endpoints</p>
  <h3> &emsp; API is documented by swagger, open <a href="http://localhost:8080/swagger-ui/">http://localhost:8080/swagger-ui/ </a></h3>
    <p> &emsp;&emsp; change host and/or port in needed</p>
  <h3> &emsp; Basic Authentication is used,</h3>
    <p> &emsp;&emsp; -use admin:admin123 credentials for ROLE_ADMIN </p>
    <p> &emsp;&emsp; -use user:user123 credentials for ROLE_USER </p>
