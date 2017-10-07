#2. Config Server
cd /c/Development/pet-store-application/netflix/config;
echo Building Config-Server
./mvnw clean install > ../../logs/config/build.log;
echo Running Config-Server
java -jar ./target/config-server.jar > ../../logs/config/run.log &
echo Config Server started as process $!
cd -
echo
echo ====================================================
echo