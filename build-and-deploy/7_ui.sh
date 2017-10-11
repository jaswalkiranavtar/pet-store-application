#7. UI
cd /c/Development/pet-store-application/app/ui;
echo Building UI
./mvnw clean install > ../../logs/ui/build.log;
echo Deploying UI
cf push
echo UI started as process $!
cd -
echo
echo ====================================================
echo