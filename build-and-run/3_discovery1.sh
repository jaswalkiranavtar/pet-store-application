#3. Discovery 1
cd /c/Development/pet-store-application/netflix/discovery;
echo Building Discovery-1
./mvnw clean install > ../../logs/discovery1/build.log;
echo Running Discovery-1
java -Dspring.profiles.active=discovery1 -jar ./target/discovery-server.jar > ../../logs/discovery1/run.log &
echo Discovery-1 started as process $!
cd -
echo
echo ====================================================
echo