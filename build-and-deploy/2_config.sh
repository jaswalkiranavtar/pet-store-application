#2. Config Server
cd /c/Development/pet-store-application/netflix/config;
echo Building Config-Server
./mvnw clean install > ../../logs/config/build.log;
echo Deploying Config-Server
cf push config-server
cd -
echo
echo ====================================================
echo