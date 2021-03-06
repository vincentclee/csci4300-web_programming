<?php
## Download latest file: course_offering_UNIV_201308.csv
## https://apps.reg.uga.edu/reporting/staticReports
system("wget -P /CSVFiles/ https://apps.reg.uga.edu/reporting/static_reports/course_offering_UNIV_201308.csv");

## Connect to a local database server (or die) ##
$dbH = mysql_connect('localhost', 'root', 'mysql') or die('Could not connect to MySQL server.<br>' . mysql_error());

## Select the database to insert to ##
mysql_select_db('CoursePicker') or die('Could not select database.<br>') . mysql_error();

## CSV file to read in ##

mysql_query('TRUNCATE TABLE CourseOfferingFall2013;');
mysql_query('LOAD DATA CONCURRENT LOCAL INFILE "/home/student/CoursePicker/CSVFiles/course_offering_UNIV_201308.csv" REPLACE
INTO TABLE CourseOfferingFall2013
FIELDS TERMINATED BY ","
OPTIONALLY ENCLOSED BY """
LINES TERMINATED BY "\n" (
Term,
CallNum,
CoursePrefix,
CourseNum,
CourseTitle,
Instructor,
Avail,
CrdHrs,
Sess,
Days,
PeriodBgn,
PeriodEnd,
CASTaken,
CASReq ,
DASTaken,
DASReq,
TotTaken,
TotReq,
TotAllow,
Bldg,
Room,
Sch,
CurrPgm);') or die('Error loading data file.<br>' . mysql_error());


## Close database connection when finished ##
mysql_close($dbH);

system("mv course_offering_UNIV_201308.csv course_offering_UNIV_201308_`date +%Y%m%d`.csv");
?>