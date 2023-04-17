docker build . -f Dockerfile.db -t db
docker build . -f Dockerfile -t app
docker stop server
docker stop database
docker rm server
docker rm database
docker run --name database --hostname db -e POSTGRES_PASSWORD=password -e POSTGRES_DB=postgres -p 5432:5432 --restart always -d --network net db
docker run --name server --hostname server -e POSTGRES_PASSWORD=password -e POSTGRES_DB=postgres -p 8080:8080 --network net --rm app