#7. UI
cd /c/Development/pet-store-application/app/ui;
echo Building UI
./mvnw clean install > ../../logs/ui/build.log;
echo Running UI
java -jar ./target/ui.jar  > ../../logs/ui/run.log &
echo UI started as process $!
cd -
echo
echo ====================================================
echo