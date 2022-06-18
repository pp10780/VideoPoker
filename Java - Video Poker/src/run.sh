javac card/*.java dealer/*.java game/*.java main/*.java player/*.java
jar cmf ../manif.txt videopoker.jar card/* dealer/* game/* main/* player/*
java -jar videopoker.jar -d 100000 ../Test_Files/81-cmd-file ../Test_Files/81-card-file