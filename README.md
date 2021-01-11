# SbringBoot REST example application
  Represents simple users API

Works with MySQL DB Server version	5.7.32
  In order to set up DB and test data:
    1 Execute:
    mysql -uroot -e "create database sbApp" -p  
    2 Execute:
    mysql -u root sbApp < path_to_init.sql -p

Import project, build and enjoy ;)...

API is documented by swagger, open <host>:<port>/swagger-ui/
  # Basic Authentication is used,
    # -use admin:admin123 credentials for ROLE_ADMIN
    # -use user:user123 credentials for ROLE_USER
