FROM arm32v7/nginx

# Copy the static content to the HTML folder of NGINX
COPY ./ /usr/share/nginx/html

# Copy the NGINX configuration
COPY ./nginx.conf /etc/nginx/conf.d/default.conf