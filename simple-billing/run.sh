docker run -d \
  -e MONGO_URI=mongodb+srv://billingapp:R177U3SVwh65EW0M@cluster0.jyf70cj.mongodb.net/billingapp \
  -e MONGO_DB_NAME=billingapp \
  -p "9191:8080" \
  itssoumen/simple-billing
