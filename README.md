
## API Reference

### Product API

##### API Test Route: /
##### Server Port: 8081 
####


| Method | API URL    | Operation              |
| :-------- | :------- | :------------------------- |
| `GET` | `/getProducts` | Get all product details |
| `GET` | `/getProducts/{productId}` | Get details of single product according to productId |
| `POST` | `/addProduct` | Create new Product details  **(Body Required )** *|
| `POST` | `/updateProduct` | Update product details  **(Body Required)** *|
| `POST` | `/products/{productId}` | Delete product details of given productId |



 **(Body Required)** * 
#### JSON Data must me passed in body
 ```
{
        "id": 124,
        "name": "Tata Punch",
        "discription": "Tata Punch price starts at ₹ 5.68 Lakh and goes upto ₹ 9.49 Lakh (Avg. ex-showroom). Punch comes in 18 variants."
}

```


### Customer API

##### API Test Route: /
##### Server Port: 8080 
####


| Method | API URL    | Operation              |
| :-------- | :------- | :------------------------- |
| `GET` | `/customers` | Get all customer details |
| `GET` | `/getcustomer/{customerId}` | Get details of single customer according to customerId |
| `POST` | `/addcustomer` | Create new customer details  **(Body Required )** *|
| `POST` | `/updatecustomer` | Update customer details  **(Body Required)** *|
| `POST` | `/deletecustomer/{customerId}` | Delete customer details of given customerId |



 **(Body Required)** * 
#### JSON Data must me passed in body
 ```
{
    "id": 7777,
    "name": "aaaaa",
    "email": "aaaaaa@gmail.com",
    "products": [
        {
            "id": 124,
            "name": "",
            "discription": ""
        },
        {
            "id": 233444,
            "name": "",
            "discription": ""
        },
        {
            "id": 888888,
            "name": "",
            "discription": ""
        },
        {
            "id": 333444,
            "name": "",
            "discription": ""
        }
    ]
}

```



