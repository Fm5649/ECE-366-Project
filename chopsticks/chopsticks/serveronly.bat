docker build . -f Dockerfile -t app
docker stop server
docker rm server
docker run --name server --hostname server -e POSTGRES_PASSWORD=password -e POSTGRES_DB=postgres -p 8080:8080 --network net --rm app