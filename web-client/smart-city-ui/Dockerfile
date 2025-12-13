# Stage 1: Build the React Application
FROM node:18-alpine as build
WORKDIR /app
COPY package.json package-lock.json* ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Serve with Nginx
FROM nginx:alpine
# Copy the build output from the previous stage to Nginx html folder
COPY --from=build /app/build /usr/share/nginx/html
# Expose port 80 (internal to container)
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]