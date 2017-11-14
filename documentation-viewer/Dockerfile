FROM node:latest


# Install and configure `serve`.
RUN npm install -g serve
CMD serve -s build
EXPOSE 3000

ADD package.json package.json
RUN npm install

COPY . .

# Build for production.
RUN npm run build --production

ENTRYPOINT npm run start