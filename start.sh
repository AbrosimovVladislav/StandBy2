#docker start
cd .docker
docker compose down
docker compose up -d
cd ..

#backapp start

#frontapp start
cd frontapp
npm i
npm start