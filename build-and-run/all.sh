#1. Build Security
./1_security.sh
sleep 5;
#2. Config Server
./2_config.sh
sleep 5;
#3. Discovery 1
./3_discovery1.sh
sleep 5;
#4. Discovery 2
./4_discovery2.sh
sleep 5;
#5. Auth Server
./5_auth.sh
sleep 5;
#6. Data Service
./6_data.sh
sleep 5;
#7. UI
./7_ui.sh