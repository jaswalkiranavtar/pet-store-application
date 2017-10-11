#Login to BMX
cf login -a https://api.ng.bluemix.net -u bluemix189@gmail.com -p bLUEMIx123@;
cf org bluemix189;
cf space dev;

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