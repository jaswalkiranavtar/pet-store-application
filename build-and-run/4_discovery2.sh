#4. Discovery 2
cd /c/Development/pet-store-application/netflix/discovery;
echo Building Discovery-2
./mvnw clean install > ../../logs/discovery2/build.log;
echo Running Discovery-2
java -Dspring.profiles.active=discovery2 -jar ./target/discovery-server.jar > ../../logs/discovery2/run.log &
echo Discovery-2 started as process $!
cd -
echo
echo ====================================================
echo