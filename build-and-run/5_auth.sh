#5. Auth Server
cd /c/Development/pet-store-application/auth;
echo Building Auth Server
./mvnw clean install > ../logs/auth/build.log;
echo Running Auth Server
java -jar ./target/auth-server-0.1-SNAPSHOT.jar > ../logs/auth/run.log &
echo Auth Server started as process $!
cd -
echo
echo ====================================================
echo