docker run -d \
  -e MONGO_URI=mongodb+srv://<username>:<password>@<clusterAddress>/billingapp \
  -e MONGO_DB_NAME=billingapp \
  -p "9191:8080" \
  itssoumen/simple-billing
