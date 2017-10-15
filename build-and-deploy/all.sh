#Login to BMX
cf login -a https://api.ng.bluemix.net -u bluemix189@gmail.com -p bLUEMIx123@;
cf org bluemix189;
cf space dev;

#Create user defined services for discovery servers
cf uups discovery-service-1 -p '{"uri":"http://petstore-discovery-1.mybluemix.net/eureka"}';
cf uups discovery-service-2 -p '{"uri":"http://petstore-discovery-2.mybluemix.net/eureka"}';
cf uups discovery-service -p '{"uri":"http://petstore-discovery-1.mybluemix.net/eureka,http://petstore-discovery-2.mybluemix.net/eureka"}';
cf uups config-service -p '{"uri":"petstore-config-server.mybluemix.net"}';
cf uups sso-service -p '{"client-id":"petstore","client-secret":"petstoresecret","auth-server-uri":"petstore-auth-server.mybluemix.net"}';

#1. Build Security
./1_security.sh
#2. Config Server
./2_config.sh
#3. Discovery 1
./3_discovery1.sh
#4. Discovery 2
./4_discovery2.sh
#5. Auth Server
./5_auth.sh
#6. Data Service
./6_data.sh
#7. UI
./7_ui.sh