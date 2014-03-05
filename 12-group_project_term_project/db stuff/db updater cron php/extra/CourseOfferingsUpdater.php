<?php
## Connect to a local database server (or die) ##
$dbH = mysql_connect('localhost', 'username', 'password') or die('Could not connect to MySQL server.<br>' . mysql_error());

## Select the database to insert to ##
mysql_select_db('database') or die('Could not select database.<br>') . mysql_error();

## CSV file to read in ##

mysql_query('DELETE FROM Offers');
mysql_query('LOAD DATA LOCAL INFILE "xxxx.csv" INTO TABLE Offers FIELDS TERMINATED BY "," ENCLOSED BY """" LINES TERMINATED BY "\n" ignore 0 lines;') or die('Error loading data file.<br>' . mysql_error());


## Close database connection when finished ##
mysql_close($dbH);
?>