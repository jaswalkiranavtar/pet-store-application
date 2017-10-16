#6. Data Service
cd /c/Development/pet-store-application/app/services/data;
echo Building Data Service
./mvnw clean install > ../../../logs/data/build.log;
echo Running Data Service
java -jar ./target/data-service-0.1-SNAPSHOT.jar  > ../../../logs/data/run.log &
echo Data Service started as process $!
cd -
echo
echo ====================================================
echo