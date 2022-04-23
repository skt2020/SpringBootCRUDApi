//import liraries
import React, { Component, useState } from 'react';
import {
  View,
  Text,
  StyleSheet,
  TextInput,
  TouchableOpacity,
} from 'react-native';

// create a component
const Detail = ({ route, navigation }) => {
  const { item } = route.params;
  let tp="";
  let productId=[];
  for (let index = 0; index < item.products.length; index++) {
    productId.push(item.products[index].id); 
}
 tp= productId.join().toString();
  const [user, setUser] = useState({
    name: item.name,
    id: item.id,
    email: item.email,
    products: tp,
   // pid:str,
    
  } 
  );
 
  let pid=[];


  const onChangeName = (value) => {
    setUser({ ...user, name: value });
  };

  const onChangeId = (value) => {
    setUser({ ...user, id: value });
  };

  const onChangeEmail = (value) => {
    setUser({ ...user, email: value });
  };
  const onChangeProducts = (value) => {
    setUser({ ...user, products: value });
    console.log(value);
  };

  const parseProductId=()=>{
    let temp=[];
    temp=user.products.split(',');
    for (let index = 0; index < temp.length; index++) {
      let element = parseInt(temp[index]);
        pid.push({'id':element});
    }
    console.log(pid);
    setUser({ ...user, productId: pid });

  }


  const updateData = () => {
    var myHeaders = new Headers();
    parseProductId();
    myHeaders.append('Content-Type', 'application/json');

    fetch('http://localhost:8080/updatecustomer', {
      method: 'POST',
      headers: myHeaders,
      body: JSON.stringify({
        name: user.name,
        id: user.id,
        email: user.email,
        products:pid,
      }),
    })
      .then((response) => {
        response.text();
        navigation.push('Get')
      })
      .then((result) => console.log(result))
      .catch((error) => console.log(error));
  };

  const deleteData = () => {
    var myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');
 

    fetch('http://localhost:8080/deletecustomer/'+item.id, {
      method: 'POST',
      headers: myHeaders,
      body: JSON.stringify({
        name: user.name,
        id: user.id,
        email: user.email,
        
      }),
    })
      .then((response) => {
        response.text();
        navigation.push('Get')
      })
      .then((result) => console.log(result))
      .catch((error) => console.log(error));
  };

  return (
    <View style={styles.container}>
      <TextInput
        placeholder={'Name'}
        onChangeText={(value) => onChangeName(value)}
        style={styles.input}
        value={user.name}
      />
      <TextInput
        placeholder={'ID'}
        onChangeText={(value) => onChangeId(value)}
        style={styles.input}
        value={user.id}
      />
      <TextInput
        placeholder={'E-mail'}
        onChangeText={(value) => onChangeEmail(value)}
        style={styles.input}
        value={user.email}
      />
      <TextInput
        placeholder={'Product Id (Comma Seprated)'}
        onChangeText={(value) => onChangeProducts(value)}
        style={styles.input}
        value={user.products}
      
      />
      <label style={{ color: 'green'}}>
           <h3>Product Details:</h3>
      </label>



  
    
  <div >
    
     <div  >
    <TextInput 
        editable={false} 
        selectTextOnFocus={false}
        style={styles.input1}
        value={"Product Id"}
      
      />

      {item.products.map(itr => (
        <TextInput
        editable={false} 
        selectTextOnFocus={false}
        placeholder={'Product Id'}
        //onChangeText={(value) => onChangeProducts(value)}
        style={styles.input}
        value={itr.id}
      />
      ))}
      
      </div>
      <div >
      <TextInput 
        editable={false} 
        selectTextOnFocus={false}
        style={styles.input1}
        value={"Product Name"}
      
      />
      {item.products.map(itr => (
        <TextInput
        editable={false} 
        selectTextOnFocus={false}
        placeholder={'Product Name'}
       // onChangeText={(value) => onChangeProducts(value)}
        style={styles.input}
        value={itr.name}
      />
      ))}
      </div>
      <div>
      <TextInput 
        editable={false} 
        selectTextOnFocus={false}
        style={styles.input1}
        value={"Product Disription"}
      
      />
      {item.products.map(itr => (
        <TextInput
        editable={false} 
        selectTextOnFocus={false}
        placeholder={'Product Disription'}
        //onChangeText={(value) => onChangeProducts(value)}
        style={styles.input}
        value={itr.discription}
      />
      ))}
      </div>
    
    </div>


      <View style={{ flexDirection: 'row' }}>
        <TouchableOpacity onPress={updateData}>
          <View style={{ backgroundColor: 'green', padding: 10, margin: 10 }}>
            <Text style={{ color: 'white', textAlign: 'center' }}>Update</Text>
          </View>
        </TouchableOpacity>

        <TouchableOpacity onPress={deleteData}>
          <View style={{ backgroundColor: 'red', padding: 10, margin: 10  }}>
            <Text style={{ color: 'white', textAlign: 'center' }}>Delete</Text>
          </View>
        </TouchableOpacity>
      </View>
    </View>
  );
};

// define your styles
const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginHorizontal: 15,
    backgroundColor: '#fff',
  },
  input: {
    height: 40,
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginVertical: 5,
  },
  input1: {
    height: 40,
    borderWidth: 1,
    borderColor: 'green',
    padding: 10,
    marginVertical: 5,
    color: 'white',
    backgroundColor: 'green',
  },
});

//make this component available to the app
export default Detail;
