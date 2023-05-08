FROM node:16.13.1-alpine as build
RUN npm install -g serve # A simple webserver
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
ENV REACT_APP_BACKEND_URL=http://20.246.192.106:8080
RUN npm run build
EXPOSE 80
CMD ["serve", "-s", "build", "-l", "80"]