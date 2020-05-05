FROM node:14.0.0-alpine
WORKDIR /app

# Install app dependencies
COPY ./package*.json ./
RUN npm install

# Bundle app source
COPY . .

EXPOSE 4000
CMD [ "node", "app.js" ]
