#! /bin/sh
java -cp ~/.m2/repository/org/hsqldb/hsqldb/2.3.2/hsqldb-2.3.2.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb
