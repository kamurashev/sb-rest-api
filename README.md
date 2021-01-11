<h1>SbringBoot REST example application</h1>
  <h3>Represents simple users API</h3>

<h2>Works with MySQL DB Server version	5.7.32</h2>
  <h3>In order to set up DB and test data:</h3>
    <p>1 Execute:</p>
    <p>mysql -uroot -e "create database sbApp" -p</p>  
    <p>2 Execute:</p>
    <p>mysql -u root sbApp < path_to_init.sql -p</p>

<h2>Import project, build and enjoy ;)...</h2>

<h2>API is documented by swagger, open http://localhost:8080/swagger-ui/</h2>
    <p>change hos and port in needed</p>
  <h3> Basic Authentication is used,</h3>
    <p> -use admin:admin123 credentials for ROLE_ADMIN </p>
    <p> -use user:user123 credentials for ROLE_USER </p>
