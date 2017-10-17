#Blue Green Deployment Steps

#1 Set up env variables
original_host="petstore-ui"
temp_host="petstore-ui-temp"
app_dir="/c/Development/pet-store-application/app/ui"
original_app_name="ui"
temp_app_name="ui-temp"
domain="mybluemix.net"
space="dev"

#2 Create a new route
cf create-route $space $domain --hostname $temp_host

#3 Push new app and map original route to new app
cd $app_dir;
echo Building UI
./mvnw clean install > ../../logs/ui/build.log;
cf push $temp_app_name -n $temp_host
cd -
cf map-route $temp_app_name $domain -n $original_host

#4 Test app now, we have both blue and green version of app running on original rooute

#5 Unmap route to old app if everything is fine
cf unmap-route $original_app_name $domain -n $original_host
cf unmap-route $temp_app_name $domain -n $temp_host

#6 Delete old app and rename new_app to old app
cf delete $original_app_name;
y;
cf rename $temp_app_name $original_app_name

#7 Delete temp route
cf delete-route $domain --hostname $temp_host;
y;

