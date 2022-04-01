# SpringBootCRUDApi


## API Reference

##### API Test Route: /
##### Server Port: 8080 
####



| Method | API URL    | Operation              |
| :-------- | :------- | :------------------------- |
| `GET` | `/products` | Get all product details |
| `GET` | `/products/{productId}` | Get details of single product according to productId |
| `POST` | `/products` | Create new Product details  **(Body Required )** *|
| `PUT` | `/products` | Update product details  **(Body Required)** *|
| `DELETE` | `/products/{productId}` | Delete product details of given productId |


 **(Body Required)** * 
#### JSON Data must me passed in body
 ```
{
        "id": 124,
        "name": "Tata Punch",
        "discription": "Tata Punch price starts at ₹ 5.68 Lakh and goes upto ₹ 9.49 Lakh (Avg. ex-showroom). Punch comes in 18 variants."
}

```
