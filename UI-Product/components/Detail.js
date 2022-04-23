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

  const [user, setUser] = useState({
    name: item.name,
    id: item.id,
    discription: item.discription,
    
  });

  const onChangeName = (value) => {
    setUser({ ...user, name: value });
  };

  const onChangeId = (value) => {
    setUser({ ...user, id: value });
  };

  const onChangeDiscription = (value) => {
    setUser({ ...user, discription: value });
  };

  

  const updateData = () => {
    var myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');

    fetch('http://localhost:8081/products', {
      method: 'PUT',
      headers: myHeaders,
      body: JSON.stringify({
        name: user.name,
        id: user.id,
        discription: user.discription,
       
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
 

    fetch('http://localhost:8081/products/'+item.id, {
      method: 'DELETE',
      headers: myHeaders,
      body: JSON.stringify({
        name: user.name,
        id: user.id,
        discription: user.discription,
        
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
        placeholder={'Discription'}
        onChangeText={(value) => onChangeDiscription(value)}
        style={styles.input}
        value={user.discription}
      />
     

      <View style={{ flexDirection: 'row' }}>
        <TouchableOpacity onPress={updateData}>
          <View style={{ backgroundColor: 'blue', padding: 10 }}>
            <Text style={{ color: 'white', textAlign: 'center' }}>Update</Text>
          </View>
        </TouchableOpacity>

        <TouchableOpacity onPress={deleteData}>
          <View style={{ backgroundColor: 'red', padding: 10 }}>
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
});

//make this component available to the app
export default Detail;
