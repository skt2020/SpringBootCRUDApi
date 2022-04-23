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
    email: '',
    productId:[],
   
  });
  let pid=[];

  const [loading, setLoading] = useState(false);

  const onChangeName = (value) => {
    setUser({ ...user, name: value });
  };

  const onChangeId = (value) => {
    setUser({ ...user, id: value });
  };
  
  const onChangeEmail = (value) => {
    setUser({ ...user, email: value });
  };

  const onChangeProductId = (value) => {
    setUser({ ...user, productId: value });
  };
  
  const parseProductId=()=>{
    let temp=[];
    temp=user.productId.split(',');
    for (let index = 0; index < temp.length; index++) {
      let element = parseInt(temp[index]);
        pid.push({'id':element});
    }
    console.log(pid);
    setUser({ ...user, productId: pid });

  }
 

  const saveData = () => {
    parseProductId();
    setLoading(true);
    var myHeaders = new Headers();

    myHeaders.append('Content-Type', 'application/json');

      console.log(pid);
    fetch('http://localhost:8080/addcustomer', {
      method: 'POST',
      headers: myHeaders,
      body: JSON.stringify({
        name: user.name,
        id: user.id,
        email: user.email,
        products:pid,
        //[{"id":124},{"id":100}]
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
        placeholder={'E-mail'}
        onChangeText={(value) => onChangeEmail(value)}
        style={styles.input}
      />
      <TextInput
        placeholder={'Product Id (Comma Separated)'}
        onChangeText={(value) => onChangeProductId(value)}
        style={styles.input}
      />
     

      <TouchableOpacity onPress={saveData}>
        <View style={{ backgroundColor: 'green', padding: 10 }}>
          <Text style={{ color: 'white', textAlign: 'center' }}>
            {loading ? 'Sending Data...' : 'Adding New Customer'}
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
