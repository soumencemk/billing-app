# Simple Billing system for Electric and Gas

---

## 1. Models/DB Entities

### 1.1 UNIT_RATE

- id
- type (GAS/ELECTRIC)
- rate_per_unit
- standing_charges
- currency
- isActive

### 1.2 METER_READING

- id
- datetime
- type
- unit_id
- meter_reading
- isBilled

### 1.3 Bill

- id
- generation_datetime
- start_date
- end_date
- start_unit
- end_unit
- unit_consumed
- type
- amount

## 2. REST APIs

### 2.1 `POST api/v1/meter/{type}`

Submit the meter reading for a specific meter type.

#### Request

```json
{
  "meter_reading": "1234",
  "date": "12/12/2022"
}
```

#### Response

```json
{
  "status": "SUCCESS",
  "meter_reading": {
    "meter_reading": "1234",
    "date": "12/12/2022"
  }
}
```

### 2.2 `GET /api/v1/meter/{type}`

Get the last meter reading for a specific type

#### Response

```json
{
  "status": "SUCCESS",
  "meter_reading": {
    "meter_reading": "1234",
    "date": "12/12/2022"
  }
}
```

### 2.3 `GET /api/v1/billing/{type}/currentusage`

See the current usage since the last billing date. First and Last un-billed reading data will be used for calculations.

#### Response

```json
{
  "date": "12/12/2022",
  "amount": "£100",
  "start_unit": "1234",
  "end_unit": "1235",
  "unit_consumed": "1",
  "total_standing_charges": "1"
}
```

### 2.4 `GET /api/v1/billing/{type}/monthEstimate`

Estimate the months bill based on current usage and last billed period

#### Response
```json
{
  "amount": "£345",
  "start_date": "12/12/1222",
  "end_date": "12/12/1222",
  "units": "122"
}
```
### 2.5 `POST /api/v1/billing/{type}/bill`

Submit an actual generated bill

#### Request Body

```json
{
  "bill_date": "12/12/2022",
  "start_date": "12/12/2222",
  "end_date": "12/12/2222",
  "amount": "£37.29",
  "start_unit": "1233",
  "end_unit": "1255"
}
```