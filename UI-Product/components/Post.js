import React, { useState } from 'react';
import {
  Text,
  View,
  StyleSheet,
  TextInput,
  TouchableOpacity,
} from 'react-native';
import Constants from 'expo-constants';

export default function Post() {
  const [user, setUser] = useState({
    name: '',
    id: '',
    discription: '',
   
  });

  const [loading, setLoading] = useState(false);

  const onChangeName = (value) => {
    setUser({ ...user, name: value });
  };

  const onChangeId = (value) => {
    setUser({ ...user, id: value });
  };

  const onChangeDiscription = (value) => {
    setUser({ ...user, discription: value });
  };

 

  const saveData = () => {
    setLoading(true);
    var myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');

    fetch('http://localhost:8081/products', {
      method: 'POST',
      headers: myHeaders,
      body: JSON.stringify({
        name: user.name,
        id: user.id,
        discription: user.discription,
      
      }),
    })
      .then((response) => {
        setLoading(false)
        response.text();
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
      />
      <TextInput
        placeholder={'Id'}
        onChangeText={(value) => onChangeId(value)}
        style={styles.input}
      />
      <TextInput
        placeholder={'Discription'}
        onChangeText={(value) => onChangeDiscription(value)}
        style={styles.input}
      />
     

      <TouchableOpacity onPress={saveData}>
        <View style={{ backgroundColor: 'blue', padding: 10 }}>
          <Text style={{ color: 'white', textAlign: 'center' }}>
            {loading ? 'Sending Data...' : 'Adding New Product'}
          </Text>
        </View>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: Constants.statusBarHeight,
    padding: 8,
    margin: 15,
  },
  input: {
    height: 40,
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginVertical: 5,
  },
});
