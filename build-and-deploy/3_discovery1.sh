#3. Discovery 1
cd /c/Development/pet-store-application/netflix/discovery;
echo Building Discovery-1
./mvnw clean install > ../../logs/discovery1/build.log;
echo Deploying Discovery-1
cf push discovery-1 -f manifest1.yml
cd -
echo
echo ====================================================
echo