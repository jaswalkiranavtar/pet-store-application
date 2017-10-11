#4. Discovery 2
cd /c/Development/pet-store-application/netflix/discovery;
echo Building Discovery-2
./mvnw clean install > ../../logs/discovery2/build.log;
echo Deploying Discovery-2
cf push discovery-2 -f manifest2.yml
cd -
echo
echo ====================================================
echo