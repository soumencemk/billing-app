docker run -d \
-e POSTGRES_URL=jdbc:postgresql://10.95.31.65:5432/simple-billing \
-e POSTGRES_USERNAME=soumen \
-e POSTGRES_PASSWORD=admin123 \
-p "9191:8080" \
itssoumen/simple-billing