#5. Auth Server
cd /c/Development/pet-store-application/auth;
echo Building Auth Server
./mvnw clean install > ../logs/auth/build.log;
echo Deploying Auth Server
cf push
cd -
echo
echo ====================================================
echo