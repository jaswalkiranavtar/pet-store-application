#6. Data Service
cd /c/Development/pet-store-application/app/services/data;
echo Building Data Service
./mvnw clean install > ../../../logs/data/build.log;
echo Deploying Data Service
cf push
cd -
echo
echo ====================================================
echo