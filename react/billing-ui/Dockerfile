FROM node:18
WORKDIR /app
COPY package*.json ./
RUN npm install --production
COPY dist ./dist
EXPOSE 3000
CMD ["npx", "http-server", "./dist", "-p", "3000"]