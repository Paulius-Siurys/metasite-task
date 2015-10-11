# metasite-task
Norint pasileisti programą reikia susikurti PostgreSQL 9.2 duombazę:
CREATE DATABASE "METASITE";

src/main/resources/application.properties faile nurodytas duombazės adresas ("db.url"), naudotojo vardas("db.username") ir slaptažodis("db.password"), kurios galima pasikeisti į tinkamus
Tame pačiame faile yra nustatymas "hibernate.hbm2ddl.auto", kurį galima pasikeiti į "update". Tada perkrovus programą duombazė nebus perkuriama (išliks seni duomenys)
Žodžių failai pagal nutylėjimą yra "output_files" kataloge

Programos paleidimas: mvn tomcat7:run
Java versija: 1.7
Programos adresas: http://localhost:8080/web/app.html