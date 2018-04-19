# apsi-innovations

## backend 

### błąd MySQL z id użytkownika
com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Specified key was too long; max key length is 1000 bytes
Rozwiązanie: set GLOBAL storage_engine='InnoDb';
